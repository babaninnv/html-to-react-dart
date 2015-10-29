package ru.babaninnv.translator.html.react.dart;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.UnsupportedEncodingException;
import java.util.List;

import org.attoparser.ParseException;
import org.attoparser.config.ParseConfiguration;
import org.attoparser.dom.DOMMarkupParser;
import org.attoparser.dom.Document;
import org.attoparser.dom.INestableNode;
import org.attoparser.dom.INode;
import org.attoparser.dom.Text;

public class Translator {
  private static Document document;

  public static void main(String[] args) {

    try {

      final InputStream is = Thread.currentThread().getContextClassLoader().getResourceAsStream("template_one.html");
      final Reader reader = new BufferedReader(new InputStreamReader(is, "ISO-8859-1"));

      DOMMarkupParser parser = new DOMMarkupParser(ParseConfiguration.htmlConfiguration());
      document = parser.parse(reader);

      System.out.println(document);
      List<INode> children = document.getChildren();
      for (int i = 0; i < children.size(); i++) {
        INode child = children.get(i);
        if (!(child instanceof INestableNode)) continue;
        parseChildren((INestableNode) children.get(i));
      }

    } catch (UnsupportedEncodingException | ParseException e) {
      e.printStackTrace();
    }
  }

  public static void parseChildren(INestableNode node) {
    System.out.println(node);

    if (!(node instanceof INestableNode)) return;
    List<INode> children = node.getChildren();
    if (children == null) return;

    for (int i = 0; i < children.size(); i++) {

      INode child = children.get(i);

      if (!(child instanceof INestableNode)) continue;

      parseChildren((INestableNode) child);
    }
  }
}
