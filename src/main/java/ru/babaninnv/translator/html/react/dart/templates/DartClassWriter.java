package ru.babaninnv.translator.html.react.dart.templates;

import static ru.babaninnv.translator.html.react.dart.utils.StringWriterUtils.writeEmpty;
import static ru.babaninnv.translator.html.react.dart.utils.StringWriterUtils.writeNextLine;

import java.io.IOException;
import java.io.Writer;

import ru.babaninnv.translator.html.react.dart.definitions.DartClass;
import ru.babaninnv.translator.html.react.dart.dom.DOMDartWriter;

public class DartClassWriter {

  private static final int OFFSET = 2;
  private static int currentLineOffset = 0;

  public static void write(DartClass dartClass, Writer writer) throws IOException {
    writeClass(dartClass, writer);
  }

  public static void writeImports(String[] imports, Writer writer) throws IOException {
    for (int i = 0; i < imports.length; i++) {
      String importItem = imports[i];

      writer.write("import ");
      writer.write('\'');
      writer.write(importItem);
      writer.write('\'');
      writeNextLine(writer);

    }
  }

  private static void writeClass(DartClass dartClass, Writer writer) throws IOException {

    // add imports

    writeImports(dartClass.imports, writer);

    writeNextLine(writer);

    // class ExmapleClassName extends Component {
    writeEmpty(currentLineOffset, writer);
    writer.write("class ");
    writer.write(dartClass.className);
    writer.write(" extends Component {");
    writeNextLine(writer);
    writeNextLine(writer);

    // add offset
    currentLineOffset += OFFSET;

    // @override
    writeEmpty(currentLineOffset, writer);
    writer.write("@override");
    writeNextLine(writer);

    // render() {
    writeEmpty(currentLineOffset, writer);
    writer.write("render() {");
    writeNextLine(writer);

    // add offset
    currentLineOffset += OFFSET;

    // return
    writeEmpty(currentLineOffset, writer);
    writer.write("return");
    writeNextLine(writer);

    // ... - react dart markup
    DOMDartWriter.currentOffset = currentLineOffset;
    DOMDartWriter.writeDocument(dartClass.document, writer);
    writer.write(';');
    writeNextLine(writer);

    // decrease offset
    currentLineOffset -= OFFSET;

    // } - close 'render' method block
    writeEmpty(currentLineOffset, writer);
    writer.write('}');
    writeNextLine(writer);

    // decrease offset
    currentLineOffset -= OFFSET;

    // } - close class block
    writeEmpty(currentLineOffset, writer);
    writer.write('}');
    writeNextLine(writer);
  }
}
