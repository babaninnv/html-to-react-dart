Converter HTML to [React-Dart](https://github.com/cleandart/react-dart#using-browser-native-elements)  format

Exmaple:
```html
<div class="col-md-4 col-sm-4">
  <div class="price-clean">
    <h4>
      <sup>$</sup>15<em>/month</em>
    </h4>
    <h5> STARTER </h5>
    <hr />
    <p>For individuals looking for something simple to get started.</p>
    <hr />
		<a href="#" class="btn btn-3d btn-teal">Learn More</a>
	</div>
</div>
```
Convert to:
```
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
```

# How to use it:

1. Clone this repository: ```git clone git@gitlab.com:nikitared/html-to-react-dart.git```
2. Run gradlew file with task installDist: ```gradlew.bat installDist```
3. Сhange root folder to build -> install -> html-to-react-dart -> bin: ```<current folder>\build\install\html-to-react-dart\bin\```
4. Run html-to-react-dart file with arguments:
  * **-h --help**    - list of commands with description
  * **-file**        - file name in current(bin) folder. This is **Required** arg. Example: ```html-to-react-dart.bat -file index.html```
  * **-out**         - directory which will be created results. Optional. Example: ```html-to-react-dart.bat -out output```
  * **-wrap-class**  - it wraps the converted DOM tree is dart class infrastructure. Default it use name from '-file' value. Optional. Default it use name from '-file' value. Optional
  * **-class-name**  - if you used '-wrap-class' then it parameter set class name for class wrapper. Value is class name in upper camel case style. Ex.: ReactDartClass. Optional
