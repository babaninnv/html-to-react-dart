package ru.babaninnv.translator.html.react.dart.handlers;

import org.attoparser.AbstractMarkupHandler;
import org.attoparser.ParseException;

public class HtmlReactDartHandler extends AbstractMarkupHandler {



  @Override
  public void handleAttribute(char[] buffer, int nameOffset, int nameLen, int nameLine, int nameCol, int operatorOffset, int operatorLen,
      int operatorLine, int operatorCol, int valueContentOffset, int valueContentLen, int valueOuterOffset, int valueOuterLen,
      int valueLine, int valueCol) throws ParseException {

      //System.out.println(new String(buffer).substring(valueContentOffset, valueContentOffset + valueContentLen));

  }

  @Override
  public void handleOpenElementStart(char[] buffer, int nameOffset, int nameLen, int line, int col) throws ParseException {
    //System.out.println("<" + new String(buffer).substring(nameOffset, nameOffset + nameLen));
    System.out.print(new String(buffer).substring(nameOffset, nameOffset + nameLen) + "({");
  }

  @Override
  public void handleOpenElementEnd(char[] buffer, int nameOffset, int nameLen, int line, int col) throws ParseException {
    //System.out.println(new String(buffer).substring(nameOffset, nameOffset + nameLen) + ">");
    System.out.print("}");
  }

  @Override
  public void handleCloseElementEnd(char[] buffer, int nameOffset, int nameLen, int line, int col) throws ParseException {
    System.out.println(")");
  }

}

