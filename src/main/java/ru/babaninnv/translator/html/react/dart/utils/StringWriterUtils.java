package ru.babaninnv.translator.html.react.dart.utils;

import java.io.IOException;
import java.io.Writer;

public class StringWriterUtils {

  private static final String LINE_SEPARATOR = System.getProperty("line.separator");

  public static void writeEmpty(int count, final Writer writer) throws IOException {
    for (int i = 0; i < count; i++) writer.write(' ');
  }

  public static void writeNextLine(final Writer writer) throws IOException {
    writer.write(LINE_SEPARATOR);
  }
}
