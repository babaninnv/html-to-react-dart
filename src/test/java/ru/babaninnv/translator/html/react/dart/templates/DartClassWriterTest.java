package ru.babaninnv.translator.html.react.dart.templates;

import static org.testng.Assert.assertTrue;
import static org.testng.Assert.fail;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.StringWriter;
import java.io.Writer;

import org.attoparser.config.ParseConfiguration;
import org.attoparser.dom.DOMMarkupParser;
import org.attoparser.dom.Document;
import org.testng.annotations.Test;

import ru.babaninnv.translator.html.react.dart.definitions.DartClass;

public class DartClassWriterTest {

  @Test
  public void write() {

    try {

      final InputStream is = new FileInputStream("index.html");
      final Reader reader = new BufferedReader(new InputStreamReader(is, "ISO-8859-1"));

      DOMMarkupParser parser = new DOMMarkupParser(ParseConfiguration.htmlConfiguration());
      Document document = parser.parse(reader);

      Writer writer = new FileWriter(new File("example_dart_class.dart"));

      DartClass dartClass = new DartClass();
      dartClass.className = "ExampleDartClass";
      dartClass.imports = new String[] {"package:react/react.dart"};
      dartClass.document = document;

      DartClassWriter.write(dartClass, writer);

      writer.flush();
      writer.close();

      reader.close();
      is.close();

      assertTrue(true);
    } catch (Exception e) {
      fail(e.getMessage(), e);
    }
  }
}
