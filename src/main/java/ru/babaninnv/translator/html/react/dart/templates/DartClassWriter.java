package ru.babaninnv.translator.html.react.dart.templates;

import static ru.babaninnv.translator.html.react.dart.utils.StringWriterUtils.writeEmpty;
import static ru.babaninnv.translator.html.react.dart.utils.StringWriterUtils.writeNextLine;

import java.io.IOException;
import java.io.Writer;

import org.apache.commons.lang3.StringUtils;
import org.attoparser.util.TextUtil;

import ru.babaninnv.translator.html.react.dart.definitions.DartClass;
import ru.babaninnv.translator.html.react.dart.dom.DOMDartWriter;

public class DartClassWriter {

  private static final int OFFSET = 2;
  private static int currentLineOffset = 0;

  public static void write(DartClass dartClass, Writer w) throws IOException {
    writeClass(dartClass, w);
  }

  public static void writeImports(String[] imports, Writer w) throws IOException {
    for (int i = 0; i < imports.length; i++) {
      String importItem = imports[i];

      w.write("import ");
      w.write('\'');
      w.write(importItem);
      w.write('\'');
      writeNextLine(w);

    }
  }

  private static void writeClass(DartClass dartClass, Writer w) throws IOException {

    // add imports

    writeImports(dartClass.imports, w);

    writeNextLine(w);

    // class ExmapleClassName extends Component {
    writeEmpty(currentLineOffset, w);
    w.write("class ");
    w.write(dartClass.className);
    w.write(" extends Component {");
    writeNextLine(w);
    writeNextLine(w);

    // add offset
    currentLineOffset += OFFSET;

      // @override
      writeEmpty(currentLineOffset, w);
      w.write("@override");
      writeNextLine(w);

      // render() {
      writeEmpty(currentLineOffset, w);
      w.write("render() {");
      writeNextLine(w);

      // add offset
      currentLineOffset += OFFSET;

        // return
        writeEmpty(currentLineOffset, w);
        w.write("return");
        writeNextLine(w);

        // ... - react dart markup
        DOMDartWriter.currentOffset = currentLineOffset;
        DOMDartWriter.writeDocument(dartClass.document, w);
        w.write(';');
        writeNextLine(w);

      // decrease offset
      currentLineOffset -= OFFSET;

      // } - close 'render' method block
      writeEmpty(currentLineOffset, w);
      w.write('}');
      writeNextLine(w);

    // decrease offset
    currentLineOffset -= OFFSET;

    // } - close class block
    writeEmpty(currentLineOffset, w);
    w.write('}');
    writeNextLine(w);
  }
}
