package ru.babaninnv.translator.html.react.dart.utils;

import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

public class TextUtils {

  private static final String LINE_SEPARATOR = System.getProperty("line.separator");

  public static String[] trim(String content) {

    String[] strings = content.split(LINE_SEPARATOR);
    List<String> parsedStrings = new ArrayList<>();

    for (int j = 0; j < strings.length; j++) {
      strings[j] = StringUtils.trimToEmpty(strings[j]);
      if (StringUtils.isEmpty(strings[j])) continue;

      parsedStrings.add(strings[j]);
    }

    return parsedStrings.toArray(new String[parsedStrings.size()]);
  }
}
