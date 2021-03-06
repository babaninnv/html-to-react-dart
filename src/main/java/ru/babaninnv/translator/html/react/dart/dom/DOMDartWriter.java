package ru.babaninnv.translator.html.react.dart.dom;

import static ru.babaninnv.translator.html.react.dart.utils.StringWriterUtils.writeEmpty;
import static ru.babaninnv.translator.html.react.dart.utils.StringWriterUtils.writeNextLine;
import static ru.babaninnv.translator.html.react.dart.utils.TextUtils.*;

import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringEscapeUtils;
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

import ru.babaninnv.translator.html.react.dart.HtmlReactAttribute;
import ru.babaninnv.translator.html.react.dart.HtmlReactAttributes;

public class DOMDartWriter {

  private static final int OFFSET = 2;
  public static int currentOffset = 0;


  public static void write(final INode node, final Writer writer) throws IOException {

    if (node == null) { return; }

    if (node instanceof Text) {
      writeText((Text) node, writer);
      return;
    }
    if (node instanceof Element) {
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
    writer.write("/* ");
    writer.write(comment.getContent());
    writer.write(" */");
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

  public static void writeReactDartElement(final Element element, final Writer writer) throws IOException {

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

    List<INode> children = filterChildren(element.getChildren());
    int childCount = children.size();

    currentOffset += OFFSET;
    for (int i = 0; i < childCount; i++) {
      INode child = children.get(i);
      write(child, writer);

      if ((childCount > 1) && (i == (childCount - 2)) && (children.get(i + 1) instanceof Comment)) {
        writer.write(' ');
        writeNextLine(writer);
        continue;
      }

      if (child instanceof Comment) {
        writer.write(' ');
        writeNextLine(writer);
        continue;
      }

      if (i < (children.size() - 1)) {
        writer.write(',');
        writer.write(' ');
        writeNextLine(writer);
        continue;
      }
    }
    writeNextLine(writer);
    currentOffset -= OFFSET;
    writeEmpty(currentOffset, writer);
    writer.write(')');

  }

  public static void writeText(final Text text, final Writer writer) throws IOException {

    validateNotNull(text, "Text node cannot be null");
    validateNotNull(writer, "Writer cannot be null");

    writeEmpty(currentOffset, writer);

    String joins = StringUtils.join(trim(text.getContent()), "\", \"");

    if (StringUtils.isEmpty(joins)) return;

    writer.write("\"" + joins + "\"");
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
    HtmlReactAttribute attribute = HtmlReactAttributes.forName(key.toCharArray(), 0, key.length());
    writer.write(attribute.getReactName());
  }

  public static void writeStyles(String style, final Writer writer) throws IOException {
    String result = "";
    writer.write(result);
  }

  private static void validateNotNull(final Object obj, final String message) {
    if (obj == null) { throw new IllegalArgumentException(message); }
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

  private static List<INode> filterChildren(List<INode> children) {

    List<INode> result = new ArrayList<>();

    for (INode node : children) {
      if (node instanceof Text) {
        String[] content = trim(((Text) node).getContent());
        String joinedString = StringUtils.join(content);
        if (StringUtils.isEmpty(joinedString)) continue;
      }

      result.add(node);
    }

    return result;
  }

  private DOMDartWriter() {
    super();
  }
}
