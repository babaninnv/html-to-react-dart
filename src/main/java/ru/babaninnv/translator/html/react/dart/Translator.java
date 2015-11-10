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

import com.beust.jcommander.JCommander;

import ru.babaninnv.translator.html.react.dart.dom.DOMDartWriter;

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

      writer = new FileWriter(new File(baseName + ".dart"));

      System.out.println("Try to read file: " + file.getAbsolutePath() + ", encoding: " + writer.getEncoding());

      final InputStream is = new FileInputStream(file);
      final Reader reader = new BufferedReader(new InputStreamReader(is, "UTF-8"));

      DOMMarkupParser parser = new DOMMarkupParser(ParseConfiguration.htmlConfiguration());
      document = parser.parse(reader);

      if ((document.getChildren() != null) && (document.getChildren().size() > 1)) {

        Document wrappedDocument = new Document("document-name");
        Element divContainer = new Element("div");

        for (INode node: document.getChildren()) {
          divContainer.addChild(node);
        }

        wrappedDocument.addChild(divContainer);
        document = wrappedDocument;
      }

      DOMDartWriter.writeDocument(document, writer);

      System.out.println("Convert complete");

      writer.flush();
      writer.close();

    } catch (ParseException | IOException e) {
      e.printStackTrace();
    }
  }
}