package ru.babaninnv.translator.html.react.dart;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

public class HtmlReactAttributesTest {

  @Test
  public void forName() {
      final HtmlReactAttribute classAttribute = HtmlReactAttributes.forName("class".toCharArray(), 0, "class".length());
      assertEquals(new String(classAttribute.reactName), "className");

      final HtmlReactAttribute idAttribute = HtmlReactAttributes.forName("id".toCharArray(), 0, "id".length());
      assertEquals(new String(idAttribute.reactName), "id");

      final HtmlReactAttribute customAttribute = HtmlReactAttributes.forName("custom".toCharArray(), 0, "custom".length());
      assertEquals(new String(customAttribute.reactName), "custom");
  }
}
