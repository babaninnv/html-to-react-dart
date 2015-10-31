package ru.babaninnv.translator.html.react.dart.dom;

import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;
import org.attoparser.dom.CDATASection;
import org.attoparser.dom.Comment;
import org.attoparser.dom.DocType;
import org.attoparser.dom.Document;
import org.attoparser.dom.Element;
import org.attoparser.dom.INode;
import org.attoparser.dom.ProcessingInstruction;
import org.attoparser.dom.Text;
import org.attoparser.dom.XmlDeclaration;

public class DOMDartWriter {

  private static final String LINE_SEPARATOR = System.getProperty("line.separator");
  private static final int OFFSET = 2;

  private static boolean skip;
  private static int currentOffset = 0;


  public static void write(final INode node, final Writer writer) throws IOException {

    if (node == null) { return; }

    if (node instanceof Text) {
      writeText((Text) node, writer);
      return;
    }
    if (node instanceof Element) {
      //writeElement((Element) node, writer);
      writeReactDartElement((Element) node, writer);
      return;
    }
    if (node instanceof Comment) {
      writeComment((Comment) node, writer);
      return;
    }
    if (node instanceof CDATASection) {
      writeCDATASection((CDATASection) node, writer);
      return;
    }
    if (node instanceof DocType) {
      writeDocType((DocType) node, writer);
      return;
    }
    if (node instanceof Document) {
      writeDocument((Document) node, writer);
      return;
    }
    if (node instanceof XmlDeclaration) {
      writeXmlDeclaration((XmlDeclaration) node, writer);
      return;
    }
    if (node instanceof ProcessingInstruction) {
      writeProcessingInstruction((ProcessingInstruction) node, writer);
      return;
    }

  }



  public static void writeCDATASection(final CDATASection cdataSection, final Writer writer) throws IOException {

    writer.write("<![CDATA[");
    writer.write(cdataSection.getContent());
    writer.write("]]>");

  }



  public static void writeComment(final Comment comment, final Writer writer) throws IOException {

    writeEmpty(currentOffset, writer);
    writer.write("// ");
    writer.write(comment.getContent());
  }



  public static void writeDocType(final DocType docType, final Writer writer) throws IOException {

    writer.write("<!DOCTYPE ");
    writer.write(docType.getRootElementName());

    final String publicId = docType.getPublicId();
    final String systemId = docType.getSystemId();
    final String internalSubset = docType.getInternalSubset();

    if (publicId != null || systemId != null) {

      final String type = (publicId == null ? "SYSTEM" : "PUBLIC");

      writer.write(' ');
      writer.write(type);

      if (publicId != null) {
        writer.write(' ');
        writer.write('"');
        writer.write(publicId);
        writer.write('"');
      }

      if (systemId != null) {
        writer.write(' ');
        writer.write('"');
        writer.write(systemId);
        writer.write('"');
      }

    }

    if (internalSubset != null) {
      writer.write(' ');
      writer.write('[');
      writer.write(internalSubset);
      writer.write(']');
    }

    writer.write('>');

  }



  public static void writeDocument(final Document document, final Writer writer) throws IOException {

    if (!document.hasChildren()) { return; }

    for (final INode child : document.getChildren()) {
      write(child, writer);
    }

  }



  public static void writeElement(final Element element, final Writer writer) throws IOException {

    writer.write('<');
    writer.write(element.getElementName());

    if (element.hasAttributes()) {
      final Map<String, String> attributes = element.getAttributeMap();
      for (final Map.Entry<String, String> attributeEntry : attributes.entrySet()) {
        writer.write(' ');
        writer.write(attributeEntry.getKey());
        writer.write('=');
        writer.write('"');
        writer.write(attributeEntry.getValue());
        writer.write('"');
      }
    }

    if (!element.hasChildren()) {
      writer.write('/');
      writer.write('>');
      return;
    }

    writer.write('>');

    for (final INode child : element.getChildren()) {
      write(child, writer);
    }


    writer.write('<');
    writer.write('/');
    writer.write(element.getElementName());
    writer.write('>');

  }

  public static void writeReactDartElement(final Element element, final Writer writer) throws IOException {

    boolean first;

    writeEmpty(currentOffset, writer);
    writer.write(element.getElementName());
    writer.write('(');
    writer.write('{');

    if (element.hasAttributes()) {
      final Map<String, String> attributes = element.getAttributeMap();
      writeAttributes(attributes, writer);
    }

    if (!element.hasChildren()) {
      writer.write('}');
      writer.write(')');

      return;
    }

    writer.write('}');
    writer.write(',');
    writer.write(' ');
    writeNextLine(writer);

    List<INode> children = element.getChildren();

    currentOffset += OFFSET;

    for (int i = 0; i < children.size(); i++) {
      INode child = children.get(i);

      write(child, writer);

      if ((child instanceof Comment) && (i < (children.size() - 2))) {
        writeNextLine(writer);
      } else if ((child instanceof Element) && (i < (children.size() - 2))) {
        writer.write(',');
        writer.write(' ');
        writeNextLine(writer);
      } else if ((child instanceof Element) && (i < (children.size() - 2))) {
        writeNextLine(writer);
      } else if ((child instanceof Text) && (i == (children.size() - 1))) {
        writeNextLine(writer);
      }
    }

    currentOffset -= OFFSET;
    writeEmpty(currentOffset, writer);
    writer.write(')');

  }


  public static void writeProcessingInstruction(final ProcessingInstruction processingInstruction, final Writer writer) throws IOException {

    writer.write('<');
    writer.write('?');
    writer.write(processingInstruction.getTarget());

    final String content = processingInstruction.getContent();
    if (content != null) {
      writer.write(' ');
      writer.write(content);
    }

    writer.write('?');
    writer.write('>');
  }

  public static void writeText(final Text text, final Writer writer) throws IOException {

    validateNotNull(text, "Text node cannot be null");
    validateNotNull(writer, "Writer cannot be null");

    String[] content = trim(text.getContent());

    if ((content == null) || (content.length == 0)) {
      skip = true;
      return;
    }

    writeEmpty(currentOffset, writer);
    writer.write("\"" + StringUtils.join(content, "\", \"") + "\"");
  }

  private static String[] trim(String content) {

    String[] strings = content.split(LINE_SEPARATOR);
    List<String> parsedStrings = new ArrayList<>();

    for (int j = 0; j < strings.length; j++) {
      strings[j] = StringUtils.trimToEmpty(strings[j]);
      if (strings[j].length() == 0) continue;

      parsedStrings.add(strings[j]);
    }

    return parsedStrings.toArray(new String[parsedStrings.size()]);

  }


  public static void writeXmlDeclaration(final XmlDeclaration xmlDeclaration, final Writer writer) throws IOException {

    validateNotNull(xmlDeclaration, "XML declaration cannot be null");
    validateNotNull(writer, "Writer cannot be null");

    writer.write("<?xml version=\"");
    writer.write(xmlDeclaration.getVersion());
    writer.write('"');

    final String encoding = xmlDeclaration.getEncoding();
    if (encoding != null) {
      writer.write(" encoding=\"");
      writer.write(encoding);
      writer.write('"');
    }

    final String standalone = xmlDeclaration.getStandalone();
    if (standalone != null) {
      writer.write(" standalone=\"");
      writer.write(standalone);
      writer.write('"');
    }

    writer.write('?');
    writer.write('>');

  }

  public static void writeEmpty(int count, final Writer writer) throws IOException {
    String result = "";

    for (int i = 0; i < count; i++) {
      result = result.concat(" ");
    }

    writer.write(result);
  }

  public static void writeAttributes(Map<String, String> attributes, final Writer writer) throws IOException {

    boolean first = true;
    for (final Map.Entry<String, String> attributeEntry : attributes.entrySet()) {

      if (!first) {
        writer.write(',');
        writer.write(' ');
      } else {
        first = false;
      }

      writer.write('"');
      writeAttributeName(attributeEntry.getKey(), writer);
      writer.write('"');
      writer.write(':');
      writer.write(' ');
      writer.write('"');
      writer.write(attributeEntry.getValue());
      writer.write('"');
    }

  }

  private static void writeAttributeName(String key, Writer writer) throws IOException {
    writer.write(key);
  }

  public static void writeStyles(String style, final Writer writer) throws IOException {
    String result = "";



    writer.write(result);
  }

  public static void writeNextLine(final Writer writer) throws IOException {
    writer.write(LINE_SEPARATOR);
  }

  private static void validateNotNull(final Object obj, final String message) {
    if (obj == null) { throw new IllegalArgumentException(message); }
  }



  private DOMDartWriter() {
    super();
  }
}
