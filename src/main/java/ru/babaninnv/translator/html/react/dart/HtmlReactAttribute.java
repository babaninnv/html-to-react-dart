package ru.babaninnv.translator.html.react.dart;

public class HtmlReactAttribute {
  final char[] htmlName;
  final char[] reactName;

  public HtmlReactAttribute(final String htmlName, final String reactName) {
    super();
    if (htmlName == null) { throw new IllegalArgumentException("Html name cannot be null"); }
    if (reactName == null) { throw new IllegalArgumentException("React name cannot be null"); }
    this.htmlName = htmlName.toLowerCase().toCharArray();
    this.reactName = reactName.toCharArray();
  }

  public char[] getReactName() {
    return reactName;
  }

  @Override
  public String toString() {
      final StringBuilder strBuilder = new StringBuilder();
      strBuilder.append(this.htmlName);
      strBuilder.append(' ');
      strBuilder.append('-');
      strBuilder.append('>');
      strBuilder.append(' ');
      strBuilder.append(this.reactName);
      return strBuilder.toString();
  }
}
