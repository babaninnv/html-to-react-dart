package ru.babaninnv.translator.html.react.dart;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.StringWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.attoparser.ParseException;
import org.attoparser.config.ParseConfiguration;
import org.attoparser.dom.CDATASection;
import org.attoparser.dom.Comment;
import org.attoparser.dom.DOMMarkupParser;
import org.attoparser.dom.DocType;
import org.attoparser.dom.Document;
import org.attoparser.dom.Element;
import org.attoparser.dom.INestableNode;
import org.attoparser.dom.INode;
import org.attoparser.dom.ProcessingInstruction;
import org.attoparser.dom.Text;
import org.attoparser.dom.XmlDeclaration;
import org.unbescape.properties.PropertiesEscape;

import ru.babaninnv.translator.html.react.dart.dom.DOMDartWriter;

public class Translator {
  private Document document;
  private StringWriter writer;
  private static final int OFFSET = 2;
  private int currentOffset = 0;

  private int col;
  private int line;
  private int lineOffset;

  private static final String LINE_SEPARATOR = System.getProperty("line.separator");

  public Translator() {
    writer = new StringWriter();
  }

  public static void main(String[] args) {
    Translator translator = new Translator();

    translator.translate();
  }

  public void translate() {
    try {
      final InputStream is = Thread.currentThread().getContextClassLoader().getResourceAsStream("template_dif_2.html");
      final Reader reader = new BufferedReader(new InputStreamReader(is, "ISO-8859-1"));



      DOMMarkupParser parser = new DOMMarkupParser(ParseConfiguration.htmlConfiguration());
      document = parser.parse(reader);

      System.out.println(document);

      try {
        DOMDartWriter.writeDocument(document, writer);
      } catch (IOException e) {
        e.printStackTrace();
      }

      /*
      List<INode> children = document.getChildren();
      for (int i = 0; i < children.size(); i++) {
        INode child = children.get(i);
        if (!(child instanceof INestableNode)) continue;
        parseChildren((INestableNode) children.get(i));

      }
      */
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
      writeAttributes(reactAttributeMap, element.getElementName().length() + 1);
      List<INode> children = node.getChildren();

      if (children == null) return;

      // if (sizeElementsOnly(children) > 0) writer.write(", ");

      lineOffset += OFFSET;

      for (int i = 0; i < children.size(); i++) {
        INode child = children.get(i);

        if (child instanceof Text) {
          textProcess((Text) child);
          continue;
        }

        if (i > 0) {
          // writer.write(", ");
          nextLine();
        }

        if (!(child instanceof INestableNode)) continue;

        if (child instanceof Element) {
          Element el = (Element) child;
          // Проверяем, есть ли в нём дочерние ноды(текст, элементы и пр)
          if (el.hasChildren()) {
            // Проверяем, один ли дочерний элемент
            if (el.getChildren().size() == 1) {
              // Проверяем, это текст?
              INode firstChild = el.getFirstChild();
              if (Text.class.isInstance(firstChild)) {
                writer.write(emptyStr(lineOffset));
                writer.write(el.getElementName() + "(");
                writeAttributes(el.getAttributeMap(), el.getElementName().length() + 1);
                writer.write(", \"" + ((Text) firstChild).getContent() + "\"");
                writer.write(")");

                continue;
              }
            }
          }
        }

        parseChildren((INestableNode) child);
      }
      lineOffset -= OFFSET;
      writer.write(")");
    }
  }

  private String emptyStr(int count) {
    String result = "";

    for (int i = 0; i < count; i++) {
      result = result.concat(" ");
    }

    return result;
  }

  private void textProcess(Text textChild) {
    String content = textChild.getContent();

    String[] strings = content.split(LINE_SEPARATOR);
    List<String> parsedStrings = new ArrayList<>();

    for (int j = 0; j < strings.length; j++) {
      strings[j] = StringUtils.trimToEmpty(strings[j]);
      if (strings[j].length() == 0) continue;

      parsedStrings.add(strings[j]);
    }

    for (int j = 0; j < parsedStrings.size(); j++) {
      if (j > 0) writer.write(", ");
      writer.write("\"" + parsedStrings.get(j) + "\"");
    }

    if (parsedStrings.size() > 0) nextLine();

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

  private void writeAttributes(Map<String, String> map, int elementOffset) {

    int attributeLineOffset = 0;

    writer.write("{");

    if (map != null) {
      String[] attributeKeys = map.keySet().toArray(new String[map.keySet().size()]);
      for (int i = 0; i < attributeKeys.length; i++) {
        String attributeKey = attributeKeys[i];
        if (i > 0) {
          writer.write(", ");
          // Ставить ли перенос?
          nextLine();
          attributeLineOffset = lineOffset + elementOffset - OFFSET + 1;
        }

        // Первый аттрибут
        writer.write(emptyStr(attributeLineOffset) + "\"" + attributeKey + "\": \"" + map.get(attributeKey) + "\"");
      }
    }

    writer.write("}");
  }



  private void writeText(Element el) {
    // start element

    writeStr(el.getElementName().concat("("));
    writeAttributes(el.getAttributeMap(), el.getElementName().length() + 1);



    writeStr(")");
  }

  private void writeElement(Element el) {
    // start element

    writeStr(el.getElementName().concat("("));
    writeAttributes(el.getAttributeMap(), el.getElementName().length() + 1);



    writeStr(")");
  }

  /**
   * img, input, br ...
   * */
  private void writeStandaloneElement(Element el) {
    // start element

    writeStr(el.getElementName().concat("("));
    writeAttributes(el.getAttributeMap(), el.getElementName().length() + 1);
    writeStr(")");
  }

  private void writeStr(String string) {
    writer.write(string);
  }

  private void nextLine() {
    writer.write(LINE_SEPARATOR);
  }
}



// перед вставкой элемента - проверять его длину, проверять длину всей строки

