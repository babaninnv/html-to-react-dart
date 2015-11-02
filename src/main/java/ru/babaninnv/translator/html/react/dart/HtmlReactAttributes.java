package ru.babaninnv.translator.html.react.dart;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

import org.attoparser.util.TextUtil;

/**
 * Structure gets from org.attoparser.HtmlElements
 * */
public class HtmlReactAttributes {
  private static final HtmlElementRepository ATTRIBUTES = new HtmlElementRepository();

  static final Set<HtmlReactAttribute> ALL_REACT_ATTRIBUTES;

  static final HtmlReactAttribute ID = new HtmlReactAttribute("id", "id");
  static final HtmlReactAttribute CLASSNAME = new HtmlReactAttribute("class", "className");
  static final HtmlReactAttribute HREF = new HtmlReactAttribute("href", "href");
  static final HtmlReactAttribute ACCEPT = new HtmlReactAttribute("accept", "accept");
  static final HtmlReactAttribute ACCEPT_CHARSET = new HtmlReactAttribute("acceptCharset", "acceptCharset");
  static final HtmlReactAttribute ACCESSKEY = new HtmlReactAttribute("accessKey", "accessKey");
  static final HtmlReactAttribute ACTION = new HtmlReactAttribute("action", "action");
  static final HtmlReactAttribute ALLOWFULLSCREEN = new HtmlReactAttribute("allowFullScreen", "allowFullScreen");
  static final HtmlReactAttribute ALLOWTRANSPARENCY = new HtmlReactAttribute("allowTransparency", "allowTransparency");
  static final HtmlReactAttribute ALT = new HtmlReactAttribute("alt", "alt");
  static final HtmlReactAttribute ASYNC = new HtmlReactAttribute("async", "async");
  static final HtmlReactAttribute AUTOCOMPLETE = new HtmlReactAttribute("autoComplete", "autoComplete");
  static final HtmlReactAttribute AUTOFOCUS = new HtmlReactAttribute("autoFocus", "autoFocus");
  static final HtmlReactAttribute AUTOPLAY = new HtmlReactAttribute("autoPlay", "autoPlay");
  static final HtmlReactAttribute CAPTURE = new HtmlReactAttribute("capture", "capture");
  static final HtmlReactAttribute CELLPADDING = new HtmlReactAttribute("cellPadding", "cellPadding");
  static final HtmlReactAttribute CELLSPACING = new HtmlReactAttribute("cellspacing", "cellSpacing");
  static final HtmlReactAttribute CHARSET = new HtmlReactAttribute("charset", "charSet");
  static final HtmlReactAttribute CHALLENGE = new HtmlReactAttribute("challenge", "challenge");
  static final HtmlReactAttribute CHECKED = new HtmlReactAttribute("checked", "checked");
  static final HtmlReactAttribute CLASSID = new HtmlReactAttribute("classID", "classID");
  static final HtmlReactAttribute COLS = new HtmlReactAttribute("cols", "cols");
  static final HtmlReactAttribute COLSPAN = new HtmlReactAttribute("colspan", "colSpan");
  static final HtmlReactAttribute CONTENT = new HtmlReactAttribute("content", "content");
  static final HtmlReactAttribute CONTENTEDITABLE = new HtmlReactAttribute("contenteditable", "contentEditable");
  static final HtmlReactAttribute CONTEXTMENU = new HtmlReactAttribute("contextMenu", "contextMenu");
  static final HtmlReactAttribute CONTROLS = new HtmlReactAttribute("controls", "controls");
  static final HtmlReactAttribute COORDS = new HtmlReactAttribute("coords", "coords");
  static final HtmlReactAttribute CROSSORIGIN = new HtmlReactAttribute("crossOrigin", "crossOrigin");
  static final HtmlReactAttribute DATA = new HtmlReactAttribute("data", "data");
  static final HtmlReactAttribute DATETIME = new HtmlReactAttribute("dateTime", "dateTime");
  static final HtmlReactAttribute DEFER = new HtmlReactAttribute("defer", "defer");
  static final HtmlReactAttribute DIR = new HtmlReactAttribute("dir", "dir");
  static final HtmlReactAttribute DISABLED = new HtmlReactAttribute("disabled", "disabled");
  static final HtmlReactAttribute DOWNLOAD = new HtmlReactAttribute("download", "download");
  static final HtmlReactAttribute DRAGGABLE = new HtmlReactAttribute("draggable", "draggable");
  static final HtmlReactAttribute ENCTYPE = new HtmlReactAttribute("encType", "encType");
  static final HtmlReactAttribute FORM = new HtmlReactAttribute("form", "form");
  static final HtmlReactAttribute FORMACTION = new HtmlReactAttribute("formAction", "formAction");
  static final HtmlReactAttribute FORMENCTYPE = new HtmlReactAttribute("formEncType", "formEncType");
  static final HtmlReactAttribute FORMMETHOD = new HtmlReactAttribute("formMethod", "formMethod");
  static final HtmlReactAttribute FORMNOVALIDATE = new HtmlReactAttribute("formNoValidate", "formNoValidate");
  static final HtmlReactAttribute FORMTARGET = new HtmlReactAttribute("formTarget", "formTarget");
  static final HtmlReactAttribute FRAMEBORDER = new HtmlReactAttribute("frameBorder", "frameBorder");
  static final HtmlReactAttribute HEADERS = new HtmlReactAttribute("headers", "headers");
  static final HtmlReactAttribute HEIGHT = new HtmlReactAttribute("height", "height");
  static final HtmlReactAttribute HIDDEN = new HtmlReactAttribute("hidden", "hidden");
  static final HtmlReactAttribute HIGH = new HtmlReactAttribute("high", "high");
  static final HtmlReactAttribute HREFLANG = new HtmlReactAttribute("hreflang", "hrefLang");
  static final HtmlReactAttribute HTMLFOR = new HtmlReactAttribute("for", "htmlFor");
  static final HtmlReactAttribute HTTPEQUIV = new HtmlReactAttribute("http-equiv", "httpEquiv");
  static final HtmlReactAttribute ICON = new HtmlReactAttribute("icon", "icon");
  static final HtmlReactAttribute INPUTMODE = new HtmlReactAttribute("inputMode", "inputMode");
  static final HtmlReactAttribute KEYPARAMS = new HtmlReactAttribute("keyParams", "keyParams");
  static final HtmlReactAttribute KEYTYPE = new HtmlReactAttribute("keyType", "keyType");
  static final HtmlReactAttribute LABEL = new HtmlReactAttribute("label", "label");
  static final HtmlReactAttribute LANG = new HtmlReactAttribute("lang", "lang");
  static final HtmlReactAttribute LIST = new HtmlReactAttribute("list", "list");
  static final HtmlReactAttribute LOOP = new HtmlReactAttribute("loop", "loop");
  static final HtmlReactAttribute LOW = new HtmlReactAttribute("low", "low");
  static final HtmlReactAttribute MANIFEST = new HtmlReactAttribute("manifest", "manifest");
  static final HtmlReactAttribute MARGINHEIGHT = new HtmlReactAttribute("marginHeight", "marginHeight");
  static final HtmlReactAttribute MARGINWIDTH = new HtmlReactAttribute("marginWidth", "marginWidth");
  static final HtmlReactAttribute MAX = new HtmlReactAttribute("max", "max");
  static final HtmlReactAttribute MAXLENGTH = new HtmlReactAttribute("maxLength", "maxLength");
  static final HtmlReactAttribute MEDIA = new HtmlReactAttribute("media", "media");
  static final HtmlReactAttribute MEDIAGROUP = new HtmlReactAttribute("mediaGroup", "mediaGroup");
  static final HtmlReactAttribute METHOD = new HtmlReactAttribute("method", "method");
  static final HtmlReactAttribute MIN = new HtmlReactAttribute("min", "min");
  static final HtmlReactAttribute MINLENGTH = new HtmlReactAttribute("minlength", "minlength");
  static final HtmlReactAttribute MULTIPLE = new HtmlReactAttribute("multiple", "multiple");
  static final HtmlReactAttribute MUTED = new HtmlReactAttribute("muted", "muted");
  static final HtmlReactAttribute NAME = new HtmlReactAttribute("name", "name");
  static final HtmlReactAttribute NOVALIDATE = new HtmlReactAttribute("noValidate", "noValidate");
  static final HtmlReactAttribute OPEN = new HtmlReactAttribute("open", "open");
  static final HtmlReactAttribute OPTIMUM = new HtmlReactAttribute("optimum", "optimum");
  static final HtmlReactAttribute PATTERN = new HtmlReactAttribute("pattern", "pattern");
  static final HtmlReactAttribute PLACEHOLDER = new HtmlReactAttribute("placeholder", "placeholder");
  static final HtmlReactAttribute POSTER = new HtmlReactAttribute("poster", "poster");
  static final HtmlReactAttribute PRELOAD = new HtmlReactAttribute("preload", "preload");
  static final HtmlReactAttribute RADIOGROUP = new HtmlReactAttribute("radioGroup", "radioGroup");
  static final HtmlReactAttribute READONLY = new HtmlReactAttribute("readOnly", "readOnly");
  static final HtmlReactAttribute REL = new HtmlReactAttribute("rel", "rel");
  static final HtmlReactAttribute REQUIRED = new HtmlReactAttribute("required", "required");
  static final HtmlReactAttribute ROLE = new HtmlReactAttribute("role", "role");
  static final HtmlReactAttribute ROWS = new HtmlReactAttribute("rows", "rows");
  static final HtmlReactAttribute ROWSPAN = new HtmlReactAttribute("rowSpan", "rowSpan");
  static final HtmlReactAttribute SANDBOX = new HtmlReactAttribute("sandbox", "sandbox");
  static final HtmlReactAttribute SCOPE = new HtmlReactAttribute("scope", "scope");
  static final HtmlReactAttribute SCOPED = new HtmlReactAttribute("scoped", "scoped");
  static final HtmlReactAttribute SCROLLING = new HtmlReactAttribute("scrolling", "scrolling");
  static final HtmlReactAttribute SEAMLESS = new HtmlReactAttribute("seamless", "seamless");
  static final HtmlReactAttribute SELECTED = new HtmlReactAttribute("selected", "selected");
  static final HtmlReactAttribute SHAPE = new HtmlReactAttribute("shape", "shape");
  static final HtmlReactAttribute SIZE = new HtmlReactAttribute("size", "size");
  static final HtmlReactAttribute SIZES = new HtmlReactAttribute("sizes", "sizes");
  static final HtmlReactAttribute SPAN = new HtmlReactAttribute("span", "span");
  static final HtmlReactAttribute SPELLCHECK = new HtmlReactAttribute("spellCheck", "spellCheck");
  static final HtmlReactAttribute SRC = new HtmlReactAttribute("src", "src");
  static final HtmlReactAttribute SRCDOC = new HtmlReactAttribute("srcDoc", "srcDoc");
  static final HtmlReactAttribute SRCSET = new HtmlReactAttribute("srcSet", "srcSet");
  static final HtmlReactAttribute START = new HtmlReactAttribute("start", "start");
  static final HtmlReactAttribute STEP = new HtmlReactAttribute("step", "step");
  static final HtmlReactAttribute STYLE = new HtmlReactAttribute("style", "style");
  static final HtmlReactAttribute SUMMARY = new HtmlReactAttribute("summary", "summary");
  static final HtmlReactAttribute TABINDEX = new HtmlReactAttribute("tabIndex", "tabIndex");
  static final HtmlReactAttribute TARGET = new HtmlReactAttribute("target", "target");
  static final HtmlReactAttribute TITLE = new HtmlReactAttribute("title", "title");
  static final HtmlReactAttribute TYPE = new HtmlReactAttribute("type", "type");
  static final HtmlReactAttribute USEMAP = new HtmlReactAttribute("useMap", "useMap");
  static final HtmlReactAttribute VALUE = new HtmlReactAttribute("value", "value");
  static final HtmlReactAttribute WIDTH = new HtmlReactAttribute("width", "width");
  static final HtmlReactAttribute WMODE = new HtmlReactAttribute("wmode", "wmode");
  static final HtmlReactAttribute WRAP = new HtmlReactAttribute("wrap", "wrap");
  static final HtmlReactAttribute AUTOCAPITALIZE = new HtmlReactAttribute("autoCapitalize", "autoCapitalize");
  static final HtmlReactAttribute AUTOCORRECT = new HtmlReactAttribute("autoCorrect", "autoCorrect");
  static final HtmlReactAttribute PROPERTY = new HtmlReactAttribute("property", "property");
  static final HtmlReactAttribute ITEMPROP = new HtmlReactAttribute("itemProp", "itemProp");
  static final HtmlReactAttribute ITEMSCOPE = new HtmlReactAttribute("itemScope", "itemScope");
  static final HtmlReactAttribute ITEMTYPE = new HtmlReactAttribute("itemType", "itemType");
  static final HtmlReactAttribute ITEMREF = new HtmlReactAttribute("itemRef", "itemRef");
  static final HtmlReactAttribute ITEMID = new HtmlReactAttribute("itemID", "itemID");
  static final HtmlReactAttribute UNSELECTABLE = new HtmlReactAttribute("unselectable", "unselectable");
  static final HtmlReactAttribute RESULTS = new HtmlReactAttribute("results", "results");
  static final HtmlReactAttribute AUTOSAVE = new HtmlReactAttribute("autoSave", "autoSave");
  static final HtmlReactAttribute CLIPPATH = new HtmlReactAttribute("clipPath", "clipPath");
  static final HtmlReactAttribute CX = new HtmlReactAttribute("cx", "cx");
  static final HtmlReactAttribute CY = new HtmlReactAttribute("cy", "cy");
  static final HtmlReactAttribute D = new HtmlReactAttribute("d", "d");
  static final HtmlReactAttribute DX = new HtmlReactAttribute("dx", "dx");
  static final HtmlReactAttribute DY = new HtmlReactAttribute("dy", "dy");
  static final HtmlReactAttribute FILL = new HtmlReactAttribute("fill", "fill");
  static final HtmlReactAttribute FILLOPACITY = new HtmlReactAttribute("fillOpacity", "fillOpacity");
  static final HtmlReactAttribute HEAD = new HtmlReactAttribute("fontFamily", "");
  static final HtmlReactAttribute FONTSIZE = new HtmlReactAttribute("fontSize", "fontSize");
  static final HtmlReactAttribute FX = new HtmlReactAttribute("fx", "fx");
  static final HtmlReactAttribute FY = new HtmlReactAttribute("fy", "fy");
  static final HtmlReactAttribute GRADIENTTRANSFORM = new HtmlReactAttribute("gradientTransform", "gradientTransform");
  static final HtmlReactAttribute GRADIENTUNITS = new HtmlReactAttribute("gradientUnits", "gradientUnits");
  static final HtmlReactAttribute MARKEREND = new HtmlReactAttribute("markerEnd", "markerEnd");
  static final HtmlReactAttribute MARKERMID = new HtmlReactAttribute("markerMid", "markerMid");
  static final HtmlReactAttribute MARKERSTART = new HtmlReactAttribute("markerStart", "markerStart");
  static final HtmlReactAttribute OFFSET = new HtmlReactAttribute("offset", "offset");
  static final HtmlReactAttribute OPACITY = new HtmlReactAttribute("opacity", "opacity");
  static final HtmlReactAttribute PATTERNCONTENTUNITS = new HtmlReactAttribute("patternContentUnits", "patternContentUnits");
  static final HtmlReactAttribute PATTERNUNITS = new HtmlReactAttribute("patternUnits", "patternUnits");
  static final HtmlReactAttribute POINTS = new HtmlReactAttribute("points", "points");
  static final HtmlReactAttribute PRESERVEASPECTRATIO = new HtmlReactAttribute("preserveAspectRatio", "preserveAspectRatio");
  static final HtmlReactAttribute R = new HtmlReactAttribute("r", "r");
  static final HtmlReactAttribute RX = new HtmlReactAttribute("rx", "rx");
  static final HtmlReactAttribute RY = new HtmlReactAttribute("ry", "ry");
  static final HtmlReactAttribute SPREADMETHOD = new HtmlReactAttribute("spreadMethod", "spreadMethod");
  static final HtmlReactAttribute STOPCOLOR = new HtmlReactAttribute("stopColor", "stopColor");
  static final HtmlReactAttribute STOPOPACITY = new HtmlReactAttribute("stopOpacity", "stopOpacity");
  static final HtmlReactAttribute STROKE = new HtmlReactAttribute("stroke", "stroke");
  static final HtmlReactAttribute STROKEDASHARRAY = new HtmlReactAttribute("strokeDasharray", "strokeDasharray");
  static final HtmlReactAttribute STROKELINECAP = new HtmlReactAttribute("strokeLinecap", "strokeLinecap");
  static final HtmlReactAttribute STROKEOPACITY = new HtmlReactAttribute("strokeOpacity", "strokeOpacity");
  static final HtmlReactAttribute STROKEWIDTH = new HtmlReactAttribute("strokeWidth", "strokeWidth");
  static final HtmlReactAttribute TEXTANCHOR = new HtmlReactAttribute("textAnchor", "textAnchor");
  static final HtmlReactAttribute TRANSFORM = new HtmlReactAttribute("transform", "transform");
  static final HtmlReactAttribute VERSION = new HtmlReactAttribute("version", "version");
  static final HtmlReactAttribute VIEWBOX = new HtmlReactAttribute("viewBox", "viewBox");
  static final HtmlReactAttribute X1 = new HtmlReactAttribute("x1", "x1");
  static final HtmlReactAttribute X2 = new HtmlReactAttribute("x2", "x2");
  static final HtmlReactAttribute X = new HtmlReactAttribute("x", "x");
  static final HtmlReactAttribute XLINKACTUATE = new HtmlReactAttribute("xlinkActuate", "xlinkActuate");
  static final HtmlReactAttribute XLINKARCROLE = new HtmlReactAttribute("xlinkArcrole", "xlinkArcrole");
  static final HtmlReactAttribute XLINKHREF = new HtmlReactAttribute("xlinkHref", "xlinkHref");
  static final HtmlReactAttribute XLINKROLE = new HtmlReactAttribute("xlinkRole", "xlinkRole");
  static final HtmlReactAttribute XLINKSHOW = new HtmlReactAttribute("xlinkShow", "xlinkShow");
  static final HtmlReactAttribute XLINKTITLE = new HtmlReactAttribute("xlinkTitle", "xlinkTitle");
  static final HtmlReactAttribute XLINKTYPE = new HtmlReactAttribute("xlinkType", "xlinkType");
  static final HtmlReactAttribute XMLBASE = new HtmlReactAttribute("xmlBase", "xmlBase");
  static final HtmlReactAttribute XMLLANG = new HtmlReactAttribute("xmlLang", "");
  static final HtmlReactAttribute XMLSPACE = new HtmlReactAttribute("xmlSpace", "xmlSpace");
  static final HtmlReactAttribute Y1 = new HtmlReactAttribute("y1", "y1");
  static final HtmlReactAttribute Y2 = new HtmlReactAttribute("y2", "y2");
  static final HtmlReactAttribute Y = new HtmlReactAttribute("y", "y");



  static {

    ALL_REACT_ATTRIBUTES =
        Collections.unmodifiableSet(new LinkedHashSet<HtmlReactAttribute>(Arrays.asList(new HtmlReactAttribute[] {ACCEPT, ACCEPT_CHARSET,
            ACCESSKEY, ACTION, ALLOWFULLSCREEN, ALLOWTRANSPARENCY, ALT, ASYNC, AUTOCOMPLETE, AUTOFOCUS, AUTOPLAY, CAPTURE, CELLPADDING,
            CELLSPACING, CHARSET, CHALLENGE, CHECKED, CLASSID, CLASSNAME, COLS, COLSPAN, CONTENT, CONTENTEDITABLE, CONTEXTMENU, CONTROLS,
            COORDS, CROSSORIGIN, DATA, DATETIME, DEFER, DIR, DISABLED, DOWNLOAD, DRAGGABLE, ENCTYPE, FORM, FORMACTION, FORMENCTYPE,
            FORMMETHOD, FORMNOVALIDATE, FORMTARGET, FRAMEBORDER, HEADERS, HEIGHT, HIDDEN, HIGH, HREF, HREFLANG, HTMLFOR, HTTPEQUIV, ICON,
            ID, INPUTMODE, KEYPARAMS, KEYTYPE, LABEL, LANG, LIST, LOOP, LOW, MANIFEST, MARGINHEIGHT, MARGINWIDTH, MAX, MAXLENGTH, MEDIA,
            MEDIAGROUP, METHOD, MIN, MINLENGTH, MULTIPLE, MUTED, NAME, NOVALIDATE, OPEN, OPTIMUM, PATTERN, PLACEHOLDER, POSTER, PRELOAD,
            RADIOGROUP, READONLY, REL, REQUIRED, ROLE, ROWS, ROWSPAN, SANDBOX, SCOPE, SCOPED, SCROLLING, SEAMLESS, SELECTED, SHAPE, SIZE,
            SIZES, SPAN, SPELLCHECK, SRC, SRCDOC, SRCSET, START, STEP, STYLE, SUMMARY, TABINDEX, TARGET, TITLE, TYPE, USEMAP, VALUE, WIDTH,
            WMODE, WRAP, AUTOCAPITALIZE, AUTOCORRECT, PROPERTY, ITEMPROP, ITEMSCOPE, ITEMTYPE, ITEMREF, ITEMID, UNSELECTABLE, RESULTS,
            AUTOSAVE, CLIPPATH, CX, CY, D, DX, DY, FILL, FILLOPACITY, HEAD, FONTSIZE, FX, FY, GRADIENTTRANSFORM, GRADIENTUNITS, MARKEREND,
            MARKERMID, MARKERSTART, OFFSET, OPACITY, PATTERNCONTENTUNITS, PATTERNUNITS, POINTS, PRESERVEASPECTRATIO, R, RX, RY,
            SPREADMETHOD, STOPCOLOR, STOPOPACITY, STROKE, STROKEDASHARRAY, STROKELINECAP, STROKEOPACITY, STROKEWIDTH, TEXTANCHOR,
            TRANSFORM, VERSION, VIEWBOX, X1, X2, X, XLINKACTUATE, XLINKARCROLE, XLINKHREF, XLINKROLE, XLINKSHOW, XLINKTITLE, XLINKTYPE,
            XMLBASE, XMLLANG, XMLSPACE, Y1, Y2, Y})));

    for (final HtmlReactAttribute element : ALL_REACT_ATTRIBUTES) {
      ATTRIBUTES.storeStandardElement(element);
    }
  }

  /*
   * Note this will always be case-insensitive, because we are dealing with HTML.
   */
  static HtmlReactAttribute forName(final char[] elementNameBuffer, final int offset, final int len) {
    if (elementNameBuffer == null) { throw new IllegalArgumentException("Buffer cannot be null"); }
    return ATTRIBUTES.getElement(elementNameBuffer, offset, len);
  }

  private HtmlReactAttributes() {
    super();
  }



  /*
   * This repository class is thread-safe. The reason for this is that it not only contains the
   * standard elements, but will also contain new instances of HtmlElement created during parsing
   * (created when asking the repository for them when they do not exist yet. As any thread can
   * create a new element, this has to be lock-protected.
   */
  static final class HtmlElementRepository {

    private final List<HtmlReactAttribute> standardRepository; // read-only, no sync needed
    private final List<HtmlReactAttribute> repository; // read-write, sync will be needed

    private final ReadWriteLock lock = new ReentrantReadWriteLock(true);
    private final Lock readLock = this.lock.readLock();
    private final Lock writeLock = this.lock.writeLock();

    HtmlElementRepository() {
      this.standardRepository = new ArrayList<HtmlReactAttribute>(178);
      this.repository = new ArrayList<HtmlReactAttribute>(178);
    }



    HtmlReactAttribute getElement(final char[] text, final int offset, final int len) {

      /*
       * We first try to find it in the repository containing the standard elements, which does not
       * need any synchronization.
       */
      int index = binarySearch(this.standardRepository, text, offset, len);

      if (index >= 0) { return this.standardRepository.get(index); }

      /*
       * We did not find it in the repository of standard elements, so let's try in the read+write
       * one, which does require synchronization through a readwrite lock.
       */

      this.readLock.lock();
      try {
        index = binarySearch(this.repository, text, offset, len);
        if (index >= 0) { return this.repository.get(index); }
      } finally {
        this.readLock.unlock();
      }

      /*
       * NOT FOUND. We need to obtain a write lock and store the text
       */
      this.writeLock.lock();
      try {
        return storeElement(text, offset, len);
      } finally {
        this.writeLock.unlock();
      }
    }


    private HtmlReactAttribute storeElement(final char[] text, final int offset, final int len) {

      final int index = binarySearch(this.repository, text, offset, len);
      if (index >= 0) {
        // It was already added while we were waiting for the lock!
        return this.repository.get(index);
      }

      final HtmlReactAttribute element = new HtmlReactAttribute(new String(text, offset, len).toLowerCase(), new String(text, offset, len).toLowerCase());

      // binary Search returned (-(insertion point) - 1)
      this.repository.add(((index + 1) * -1), element);

      return element;

    }


    private HtmlReactAttribute storeStandardElement(final HtmlReactAttribute element) {

      // This method will only be called from within the HtmlElements class itself, during
      // initialization of
      // standard elements.

      this.standardRepository.add(element);
      this.repository.add(element);
      Collections.sort(this.standardRepository, ReactAttributeComparator.INSTANCE);
      Collections.sort(this.repository, ReactAttributeComparator.INSTANCE);

      return element;

    }



    private static int binarySearch(final List<HtmlReactAttribute> values, final char[] text, final int offset, final int len) {

      int low = 0;
      int high = values.size() - 1;

      int mid, cmp;
      char[] midVal;

      while (low <= high) {

        mid = (low + high) >>> 1;
        midVal = values.get(mid).htmlName;

        cmp = TextUtil.compareTo(false, midVal, 0, midVal.length, text, offset, len);

        if (cmp < 0) {
          low = mid + 1;
        } else if (cmp > 0) {
          high = mid - 1;
        } else {
          // Found!!
          return mid;
        }

      }

      return -(low + 1); // Not Found!! We return (-(insertion point) - 1), to guarantee all
                         // non-founds are < 0

    }


    private static class ReactAttributeComparator implements Comparator<HtmlReactAttribute> {

      private static ReactAttributeComparator INSTANCE = new ReactAttributeComparator();

      public int compare(final HtmlReactAttribute o1, final HtmlReactAttribute o2) {
        return TextUtil.compareTo(false, o1.htmlName, o2.htmlName);
      }
    }

  }


}
