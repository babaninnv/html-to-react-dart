package ru.babaninnv.translator.html.react.dart;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;

import org.apache.commons.io.FilenameUtils;
import org.attoparser.ParseException;
import org.attoparser.config.ParseConfiguration;
import org.attoparser.dom.DOMMarkupParser;
import org.attoparser.dom.Document;
import org.attoparser.dom.Element;
import org.attoparser.dom.INode;

import ru.babaninnv.translator.html.react.dart.definitions.DartClass;
import ru.babaninnv.translator.html.react.dart.dom.DOMDartWriter;
import ru.babaninnv.translator.html.react.dart.templates.DartClassWriter;

import com.beust.jcommander.JCommander;
import com.google.common.base.CaseFormat;

public class Translator {
  private Document document;
  private FileWriter writer;

  private Cli cli;

  public static void main(String[] args) {
    Cli cli = new Cli();
    JCommander jCommander = new JCommander(cli);
    jCommander.parse(args);

    Translator translator = new Translator();
    translator.setParameters(cli);
    translator.translate();
  }

  private void setParameters(Cli cli) {
    this.cli = cli;
  }

  public void translate() {

    File file = new File(cli.getFileName());
    if (!file.exists()) {
      System.out.println("Selected file does not exist");
      return;
    }

    String baseName = FilenameUtils.getBaseName(file.getName());

    try {
      System.out.println("Try to read file: " + file.getAbsolutePath());

      final InputStream is = new FileInputStream(file);
      final Reader reader = new BufferedReader(new InputStreamReader(is, "UTF-8"));

      DOMMarkupParser parser = new DOMMarkupParser(ParseConfiguration.htmlConfiguration());
      document = parser.parse(reader);
      document = prepareDocument(document);

      chooseScenary(baseName);

      System.out.println("Convert complete");

      writer.flush();
      writer.close();

    } catch (ParseException | IOException e) {
      e.printStackTrace();
    }
  }

  private void chooseScenary(String baseName) throws IOException, ParseException {

    if (Boolean.valueOf(cli.getWrapClass())) {
      String wrapperClassNameCamelCase = cli.getClassName();
      String wrapperClassNameUnderscore = baseName;

      if (wrapperClassNameCamelCase.length() > 0) {
        wrapperClassNameUnderscore = CaseFormat.UPPER_CAMEL.to(CaseFormat.LOWER_UNDERSCORE, wrapperClassNameCamelCase);
      } else {
        wrapperClassNameCamelCase = CaseFormat.LOWER_UNDERSCORE.to(CaseFormat.UPPER_CAMEL, wrapperClassNameUnderscore);
      }

      writer = new FileWriter(new File(wrapperClassNameUnderscore + ".dart"));

      // convert HTML with class wrapper
      convertHtmlWithClassWrapper(wrapperClassNameCamelCase, document);
    } else {
      writer = new FileWriter(new File(baseName + ".dart"));

     // convert HTML only
      convertOnlyHtml(document);
    }
  }

  private void convertHtmlWithClassWrapper(final String className, final Document document) throws ParseException, IOException {

    DartClass dartClass = new DartClass();
    dartClass.imports = new String[] { "package:react/react.dart" };
    dartClass.className = className;
    dartClass.document = document;

    DartClassWriter.write(dartClass, writer);

  }

  private void convertOnlyHtml(final Document document) throws ParseException, IOException {
    DOMDartWriter.writeDocument(document, writer);
  }

  private Document prepareDocument(Document document) {
    if ((document.getChildren() == null) || (document.getChildren().size() <= 1)) return document;

    Document wrappedDocument = new Document("document-name");
    Element divContainer = new Element("div");

    for (INode node: document.getChildren()) divContainer.addChild(node);

    wrappedDocument.addChild(divContainer);

    return wrappedDocument;

  }
}