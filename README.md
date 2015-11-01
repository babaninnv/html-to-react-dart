Converter HTML to [React-Dart](url "https://github.com/cleandart/react-dart#using-browser-native-elements")  format

Exmaple:
`
&lt;div class=&quot;col-md-4 col-sm-4&quot;&gt;
  &lt;div class=&quot;price-clean&quot;&gt;
    &lt;h4&gt;
      &lt;sup&gt;$&lt;/sup&gt;15&lt;em&gt;/month&lt;/em&gt;
    &lt;/h4&gt;
    &lt;h5&gt; STARTER &lt;/h5&gt;
    &lt;hr /&gt;
    &lt;p&gt;For individuals looking for something simple to get started.&lt;/p&gt;
    &lt;hr /&gt;
    &lt;a href=&quot;#&quot; class=&quot;btn btn-3d btn-teal&quot;&gt;Learn More&lt;/a&gt;
  &lt;/div&gt;
&lt;/div&gt;
`
Convert to:
<pre><code>
div({"class": "col-md-4 col-sm-4"},
  div({"class": "price-clean"},
    h4({},
      sup({},
        "$"
      ),
      "15",
      em({},
        "/month"
      )
    ),
    h5({},
      "STARTER"
    ),
    hr({}),
    p({},
      "For individuals looking for something simple to get started."
    ),
    hr({}),
    a({"href": "#", "class": "btn btn-3d btn-teal"},
      "Learn More"
    )
  )
)
</code></pre>