package ru.babaninnv.translator.html.react.dart;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.StringWriter;
import java.io.UnsupportedEncodingException;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.attoparser.ParseException;
import org.attoparser.config.ParseConfiguration;
import org.attoparser.dom.DOMMarkupParser;
import org.attoparser.dom.Document;
import org.attoparser.dom.Element;
import org.attoparser.dom.INestableNode;
import org.attoparser.dom.INode;
import org.attoparser.dom.Text;

public class Translator {
  private Document document;
  private StringWriter writer;
  private static final int OFFSET = 2;
  private int currentOffset = 0;

  public Translator() {
    writer = new StringWriter();
  }

  public static void main(String[] args) {
    Translator translator = new Translator();
    translator.translate();
  }

  public void translate() {
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

      System.out.println(writer.toString());

    } catch (UnsupportedEncodingException | ParseException e) {
      e.printStackTrace();
    }
  }

  public void parseChildren(INestableNode node) {
    if (!(node instanceof INestableNode)) return;
    if (node instanceof Element) {
      Element element = (Element) node;
      Map<String, String> reactAttributeMap = getReactModifedAttribute(element.getAttributeMap());

      writer.write(element.getElementName() + "(");
      writeAttributes(reactAttributeMap);
      List<INode> children = node.getChildren();

      if (children == null) return;

      if (sizeElementsOnly(children) > 0) writer.write(", ");

      for (int i = 0; i < children.size(); i++) {

        if (i > 0) writer.write(", ");

        INode child = children.get(i);

        if (child instanceof Text) {

          Text textChild = (Text)child;


          if (i > 0) writer.write("\"" + ((Text)(child)).getContent() + "\"");
        }

        if (!(child instanceof INestableNode)) continue;
        parseChildren((INestableNode) child);
      }

      writer.write(")\n");
    }
  }

  private int sizeElementsOnly(List<INode> children) {

    int elementsCount = 0;

    for (INode iNode : children) {
      if (iNode instanceof Element) elementsCount++;
    }

    return elementsCount;
  }

  private Map<String, String> getReactModifedAttribute(Map<String, String> attributeMap) {

    Map<String, String> result = new LinkedHashMap<>();

    for (String attributeKey : attributeMap.keySet()) {
      String attributeValue = attributeMap.get(attributeKey);

      if (attributeKey.equals("class")) {
        attributeKey = "className";
      }

      result.put(attributeKey, attributeValue);
    }

    return Collections.unmodifiableMap(result);
  }

  private void writeAttributes(Map<String, String> map) {
    writer.write("{");

    if (map != null) {
      String[] attributeKeys = map.keySet().toArray(new String[map.keySet().size()]);
      for (int i = 0; i < attributeKeys.length; i++) {
        String attributeKey = attributeKeys[i];
        if (i > 0) writer.write(", ");
        writer.write("\"" + attributeKey + "\": \"" + map.get(attributeKey) + "\"");
      }
    }

    writer.write("}");
  }
}
