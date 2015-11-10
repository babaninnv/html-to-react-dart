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
  private static final HtmlReactAttributeRepository ATTRIBUTES = new HtmlReactAttributeRepository();

  static final Set<HtmlReactAttribute> ALL_REACT_ATTRIBUTES;

  static final HtmlReactAttribute CLASSNAME = new HtmlReactAttribute("class", "className");
  static final HtmlReactAttribute ACCEPT_CHARSET = new HtmlReactAttribute("acceptCharset", "acceptCharset");
  static final HtmlReactAttribute ACCESSKEY = new HtmlReactAttribute("accessKey", "accessKey");
  static final HtmlReactAttribute ACTION = new HtmlReactAttribute("action", "action");
  static final HtmlReactAttribute ALLOWFULLSCREEN = new HtmlReactAttribute("allowfullscreen", "allowFullScreen");
  static final HtmlReactAttribute ALLOWTRANSPARENCY = new HtmlReactAttribute("allowTransparency", "allowTransparency");
  static final HtmlReactAttribute AUTOCOMPLETE = new HtmlReactAttribute("autoComplete", "autoComplete");
  static final HtmlReactAttribute AUTOFOCUS = new HtmlReactAttribute("autoFocus", "autoFocus");
  static final HtmlReactAttribute AUTOPLAY = new HtmlReactAttribute("autoPlay", "autoPlay");
  static final HtmlReactAttribute CAPTURE = new HtmlReactAttribute("capture", "capture");
  static final HtmlReactAttribute CELLPADDING = new HtmlReactAttribute("cellPadding", "cellPadding");
  static final HtmlReactAttribute CELLSPACING = new HtmlReactAttribute("cellspacing", "cellSpacing");
  static final HtmlReactAttribute CHARSET = new HtmlReactAttribute("charset", "charSet");
  static final HtmlReactAttribute CLASSID = new HtmlReactAttribute("classID", "classID");
  static final HtmlReactAttribute COLSPAN = new HtmlReactAttribute("colspan", "colSpan");
  static final HtmlReactAttribute CONTENT = new HtmlReactAttribute("content", "content");
  static final HtmlReactAttribute CONTENTEDITABLE = new HtmlReactAttribute("contenteditable", "contentEditable");
  static final HtmlReactAttribute CONTEXTMENU = new HtmlReactAttribute("contextMenu", "contextMenu");
  static final HtmlReactAttribute CONTROLS = new HtmlReactAttribute("controls", "controls");
  static final HtmlReactAttribute COORDS = new HtmlReactAttribute("coords", "coords");
  static final HtmlReactAttribute CROSSORIGIN = new HtmlReactAttribute("crossOrigin", "crossOrigin");
  static final HtmlReactAttribute DATA = new HtmlReactAttribute("data", "data");
  static final HtmlReactAttribute DATETIME = new HtmlReactAttribute("dateTime", "dateTime");
  static final HtmlReactAttribute DRAGGABLE = new HtmlReactAttribute("draggable", "draggable");
  static final HtmlReactAttribute ENCTYPE = new HtmlReactAttribute("enctype", "encType");
  static final HtmlReactAttribute FORM = new HtmlReactAttribute("form", "form");
  static final HtmlReactAttribute FORMACTION = new HtmlReactAttribute("formAction", "formAction");
  static final HtmlReactAttribute FORMENCTYPE = new HtmlReactAttribute("formEncType", "formEncType");
  static final HtmlReactAttribute FORMMETHOD = new HtmlReactAttribute("formMethod", "formMethod");
  static final HtmlReactAttribute FORMNOVALIDATE = new HtmlReactAttribute("formNoValidate", "formNoValidate");
  static final HtmlReactAttribute FORMTARGET = new HtmlReactAttribute("formTarget", "formTarget");
  static final HtmlReactAttribute FRAMEBORDER = new HtmlReactAttribute("frameBorder", "frameBorder");
  static final HtmlReactAttribute HREFLANG = new HtmlReactAttribute("hreflang", "hrefLang");
  static final HtmlReactAttribute HTMLFOR = new HtmlReactAttribute("for", "htmlFor");
  static final HtmlReactAttribute HTTPEQUIV = new HtmlReactAttribute("http-equiv", "httpEquiv");
  static final HtmlReactAttribute ICON = new HtmlReactAttribute("icon", "icon");
  static final HtmlReactAttribute INPUTMODE = new HtmlReactAttribute("inputMode", "inputMode");
  static final HtmlReactAttribute KEYPARAMS = new HtmlReactAttribute("keyParams", "keyParams");
  static final HtmlReactAttribute KEYTYPE = new HtmlReactAttribute("keyType", "keyType");
  static final HtmlReactAttribute MARGINHEIGHT = new HtmlReactAttribute("marginHeight", "marginHeight");
  static final HtmlReactAttribute MARGINWIDTH = new HtmlReactAttribute("marginWidth", "marginWidth");
  static final HtmlReactAttribute MAXLENGTH = new HtmlReactAttribute("maxLength", "maxLength");
  static final HtmlReactAttribute MEDIAGROUP = new HtmlReactAttribute("mediaGroup", "mediaGroup");
  static final HtmlReactAttribute NOVALIDATE = new HtmlReactAttribute("noValidate", "noValidate");
  static final HtmlReactAttribute RADIOGROUP = new HtmlReactAttribute("radioGroup", "radioGroup");
  static final HtmlReactAttribute READONLY = new HtmlReactAttribute("readonly", "readOnly");
  static final HtmlReactAttribute ROWSPAN = new HtmlReactAttribute("rowspan", "rowSpan");
  static final HtmlReactAttribute SPELLCHECK = new HtmlReactAttribute("spellCheck", "spellCheck");
  static final HtmlReactAttribute SRCDOC = new HtmlReactAttribute("srcDoc", "srcDoc");
  static final HtmlReactAttribute SRCSET = new HtmlReactAttribute("srcSet", "srcSet");
  static final HtmlReactAttribute TABINDEX = new HtmlReactAttribute("tabIndex", "tabIndex");
  static final HtmlReactAttribute USEMAP = new HtmlReactAttribute("useMap", "useMap");
  static final HtmlReactAttribute AUTOCAPITALIZE = new HtmlReactAttribute("autoCapitalize", "autoCapitalize");
  static final HtmlReactAttribute AUTOCORRECT = new HtmlReactAttribute("autoCorrect", "autoCorrect");
  static final HtmlReactAttribute PROPERTY = new HtmlReactAttribute("property", "property");
  static final HtmlReactAttribute ITEMPROP = new HtmlReactAttribute("itemProp", "itemProp");
  static final HtmlReactAttribute ITEMSCOPE = new HtmlReactAttribute("itemScope", "itemScope");
  static final HtmlReactAttribute ITEMTYPE = new HtmlReactAttribute("itemType", "itemType");
  static final HtmlReactAttribute ITEMREF = new HtmlReactAttribute("itemRef", "itemRef");
  static final HtmlReactAttribute ITEMID = new HtmlReactAttribute("itemID", "itemID");
  static final HtmlReactAttribute UNSELECTABLE = new HtmlReactAttribute("unselectable", "unselectable");
  static final HtmlReactAttribute AUTOSAVE = new HtmlReactAttribute("autoSave", "autoSave");
  static final HtmlReactAttribute CLIPPATH = new HtmlReactAttribute("clipPath", "clipPath");
  static final HtmlReactAttribute FILLOPACITY = new HtmlReactAttribute("fillOpacity", "fillOpacity");
  static final HtmlReactAttribute HEAD = new HtmlReactAttribute("fontFamily", "fontFamily");
  static final HtmlReactAttribute FONTSIZE = new HtmlReactAttribute("fontSize", "fontSize");
  static final HtmlReactAttribute GRADIENTTRANSFORM = new HtmlReactAttribute("gradientTransform", "gradientTransform");
  static final HtmlReactAttribute GRADIENTUNITS = new HtmlReactAttribute("gradientUnits", "gradientUnits");
  static final HtmlReactAttribute MARKEREND = new HtmlReactAttribute("markerEnd", "markerEnd");
  static final HtmlReactAttribute MARKERMID = new HtmlReactAttribute("markerMid", "markerMid");
  static final HtmlReactAttribute MARKERSTART = new HtmlReactAttribute("markerStart", "markerStart");
  static final HtmlReactAttribute PATTERNCONTENTUNITS = new HtmlReactAttribute("patternContentUnits", "patternContentUnits");
  static final HtmlReactAttribute PATTERNUNITS = new HtmlReactAttribute("patternUnits", "patternUnits");
  static final HtmlReactAttribute PRESERVEASPECTRATIO = new HtmlReactAttribute("preserveAspectRatio", "preserveAspectRatio");
  static final HtmlReactAttribute SPREADMETHOD = new HtmlReactAttribute("spreadMethod", "spreadMethod");
  static final HtmlReactAttribute STOPCOLOR = new HtmlReactAttribute("stopColor", "stopColor");
  static final HtmlReactAttribute STOPOPACITY = new HtmlReactAttribute("stopOpacity", "stopOpacity");
  static final HtmlReactAttribute STROKEDASHARRAY = new HtmlReactAttribute("strokeDasharray", "strokeDasharray");
  static final HtmlReactAttribute STROKELINECAP = new HtmlReactAttribute("strokeLinecap", "strokeLinecap");
  static final HtmlReactAttribute STROKEOPACITY = new HtmlReactAttribute("strokeOpacity", "strokeOpacity");
  static final HtmlReactAttribute STROKEWIDTH = new HtmlReactAttribute("strokeWidth", "strokeWidth");
  static final HtmlReactAttribute TEXTANCHOR = new HtmlReactAttribute("textAnchor", "textAnchor");
  static final HtmlReactAttribute VIEWBOX = new HtmlReactAttribute("viewBox", "viewBox");
  static final HtmlReactAttribute XLINKACTUATE = new HtmlReactAttribute("xlinkActuate", "xlinkActuate");
  static final HtmlReactAttribute XLINKARCROLE = new HtmlReactAttribute("xlinkArcrole", "xlinkArcrole");
  static final HtmlReactAttribute XLINKHREF = new HtmlReactAttribute("xlinkHref", "xlinkHref");
  static final HtmlReactAttribute XLINKROLE = new HtmlReactAttribute("xlinkRole", "xlinkRole");
  static final HtmlReactAttribute XLINKSHOW = new HtmlReactAttribute("xlinkShow", "xlinkShow");
  static final HtmlReactAttribute XLINKTITLE = new HtmlReactAttribute("xlinkTitle", "xlinkTitle");
  static final HtmlReactAttribute XLINKTYPE = new HtmlReactAttribute("xlinkType", "xlinkType");
  static final HtmlReactAttribute XMLBASE = new HtmlReactAttribute("xmlBase", "xmlBase");
  static final HtmlReactAttribute XMLLANG = new HtmlReactAttribute("xmlLang", "xmlLang");
  static final HtmlReactAttribute XMLSPACE = new HtmlReactAttribute("xmlSpace", "xmlSpace");

  static final HtmlReactAttribute onchange = new HtmlReactAttribute("onchange", "onChange");

  static final HtmlReactAttribute onClick = new HtmlReactAttribute("onClick", "onClick");
  static final HtmlReactAttribute onContextMenu = new HtmlReactAttribute("onContextMenu", "onContextMenu");
  static final HtmlReactAttribute onDoubleClick = new HtmlReactAttribute("onDoubleClick", "onDoubleClick");
  static final HtmlReactAttribute onDrag = new HtmlReactAttribute("onDrag", "onDrag");
  static final HtmlReactAttribute onDragEnd = new HtmlReactAttribute("onDragEnd", "onDragEnd");
  static final HtmlReactAttribute onDragEnter = new HtmlReactAttribute("onDragEnter", "onDragEnter");
  static final HtmlReactAttribute onDragExit = new HtmlReactAttribute("onDragExit", "onDragExit");
  static final HtmlReactAttribute onDragLeave = new HtmlReactAttribute("onDragLeave", "onDragLeave");
  static final HtmlReactAttribute onDragOver = new HtmlReactAttribute("onDragOver", "onDragOver");
  static final HtmlReactAttribute onDragStart = new HtmlReactAttribute("onDragStart", "onDragStart");
  static final HtmlReactAttribute onDrop = new HtmlReactAttribute("onDrop", "onDrop");
  static final HtmlReactAttribute onMouseDown = new HtmlReactAttribute("onMouseDown", "onMouseDown");
  static final HtmlReactAttribute onMouseEnter = new HtmlReactAttribute("onMouseEnter", "onMouseEnter");
  static final HtmlReactAttribute onMouseLeave = new HtmlReactAttribute("onMouseLeave", "onMouseLeave");
  static final HtmlReactAttribute onMouseMove = new HtmlReactAttribute("onMouseMove", "onMouseMove");
  static final HtmlReactAttribute onMouseOut = new HtmlReactAttribute("onMouseOut", "onMouseOut");
  static final HtmlReactAttribute onMouseOver = new HtmlReactAttribute("onMouseOver", "onMouseOver");
  static final HtmlReactAttribute onMouseUp = new HtmlReactAttribute("onMouseUp", "onMouseUp");
  static final HtmlReactAttribute onSelect = new HtmlReactAttribute("onSelect", "onSelect");
  static final HtmlReactAttribute onTouchCancel = new HtmlReactAttribute("onTouchCancel", "onTouchCancel");
  static final HtmlReactAttribute onTouchEnd = new HtmlReactAttribute("onTouchEnd", "onTouchEnd");
  static final HtmlReactAttribute onTouchMove = new HtmlReactAttribute("onTouchMove", "onTouchMove");
  static final HtmlReactAttribute onTouchStart = new HtmlReactAttribute("onTouchStart", "onTouchStart");
  static final HtmlReactAttribute onAbort = new HtmlReactAttribute("onAbort", "onAbort");
  static final HtmlReactAttribute onCanPlay = new HtmlReactAttribute("onCanPlay", "onCanPlay");
  static final HtmlReactAttribute onCanPlayThrough = new HtmlReactAttribute("onCanPlayThrough", "onCanPlayThrough");
  static final HtmlReactAttribute onDurationChange = new HtmlReactAttribute("onDurationChange", "onDurationChange");
  static final HtmlReactAttribute onEmptied = new HtmlReactAttribute("onEmptied", "onEmptied");
  static final HtmlReactAttribute onEncrypted = new HtmlReactAttribute("onEncrypted", "onEncrypted");
  static final HtmlReactAttribute onEnded = new HtmlReactAttribute("onEnded", "onEnded");
  static final HtmlReactAttribute onError = new HtmlReactAttribute("onError", "onError");
  static final HtmlReactAttribute onLoadedData = new HtmlReactAttribute("onLoadedData", "onLoadedData");
  static final HtmlReactAttribute onLoadedMetadata = new HtmlReactAttribute("onLoadedMetadata", "onLoadedMetadata");
  static final HtmlReactAttribute onLoadStart = new HtmlReactAttribute("onLoadStart", "onLoadStart");
  static final HtmlReactAttribute onPause = new HtmlReactAttribute("onPause", "onPause");
  static final HtmlReactAttribute onPlay = new HtmlReactAttribute("onPlay", "onPlay");
  static final HtmlReactAttribute onPlaying = new HtmlReactAttribute("onPlaying", "onPlaying");
  static final HtmlReactAttribute onProgress = new HtmlReactAttribute("onProgress", "onProgress");
  static final HtmlReactAttribute onRateChange = new HtmlReactAttribute("onRateChange", "onRateChange");
  static final HtmlReactAttribute onSeeked = new HtmlReactAttribute("onSeeked", "onSeeked");
  static final HtmlReactAttribute onSeeking = new HtmlReactAttribute("onSeeking", "onSeeking");
  static final HtmlReactAttribute onStalled = new HtmlReactAttribute("onStalled", "onStalled");
  static final HtmlReactAttribute onSuspend = new HtmlReactAttribute("onSuspend", "onSuspend");
  static final HtmlReactAttribute onTimeUpdate = new HtmlReactAttribute("onTimeUpdate", "onTimeUpdate");
  static final HtmlReactAttribute onVolumeChange = new HtmlReactAttribute("onVolumeChange", "onVolumeChange");
  static final HtmlReactAttribute onWaiting = new HtmlReactAttribute("onWaiting", "onWaiting");

  static {

    ALL_REACT_ATTRIBUTES =
        Collections.unmodifiableSet(new LinkedHashSet<HtmlReactAttribute>(Arrays.asList(new HtmlReactAttribute[] {ACCEPT_CHARSET,
            ACCESSKEY, ACTION, ALLOWFULLSCREEN, ALLOWTRANSPARENCY, AUTOCOMPLETE, AUTOFOCUS, AUTOPLAY, CAPTURE, CELLPADDING, CELLSPACING,
            CHARSET, CLASSID, CLASSNAME, COLSPAN, CONTENT, CONTENTEDITABLE, CONTEXTMENU, CONTROLS, COORDS, CROSSORIGIN, DATA, DATETIME,
            DRAGGABLE, ENCTYPE, FORM, FORMACTION, FORMENCTYPE, FORMMETHOD, FORMNOVALIDATE, FORMTARGET, FRAMEBORDER, HREFLANG, HTMLFOR,
            HTTPEQUIV, ICON, INPUTMODE, KEYPARAMS, KEYTYPE, MARGINHEIGHT, MARGINWIDTH, MAXLENGTH, MEDIAGROUP, NOVALIDATE, RADIOGROUP,
            READONLY, ROWSPAN, SPELLCHECK, SRCDOC, SRCSET, TABINDEX, USEMAP, AUTOCAPITALIZE, AUTOCORRECT, PROPERTY, ITEMPROP, ITEMSCOPE,
            ITEMTYPE, ITEMREF, ITEMID, UNSELECTABLE, AUTOSAVE, CLIPPATH, FILLOPACITY, HEAD, FONTSIZE, GRADIENTTRANSFORM, GRADIENTUNITS,
            MARKEREND, MARKERMID, MARKERSTART, PATTERNCONTENTUNITS, PATTERNUNITS, PRESERVEASPECTRATIO, SPREADMETHOD, STOPCOLOR,
            STOPOPACITY, STROKEDASHARRAY, STROKELINECAP, STROKEOPACITY, STROKEWIDTH, TEXTANCHOR, VIEWBOX, XLINKACTUATE, XLINKARCROLE,
            XLINKHREF, XLINKROLE, XLINKSHOW, XLINKTITLE, XLINKTYPE, XMLBASE, XMLLANG, XMLSPACE})));

    for (final HtmlReactAttribute element : ALL_REACT_ATTRIBUTES) {
      ATTRIBUTES.storeStandardElement(element);
    }
  }

  /*
   * Note this will always be case-insensitive, because we are dealing with HTML.
   */
  public static HtmlReactAttribute forName(final char[] elementNameBuffer, final int offset, final int len) {
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
  static final class HtmlReactAttributeRepository {

    private final List<HtmlReactAttribute> standardRepository; // read-only, no sync needed
    private final List<HtmlReactAttribute> repository; // read-write, sync will be needed

    private final ReadWriteLock lock = new ReentrantReadWriteLock(true);
    private final Lock readLock = this.lock.readLock();
    private final Lock writeLock = this.lock.writeLock();

    HtmlReactAttributeRepository() {
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

      final HtmlReactAttribute element =
          new HtmlReactAttribute(new String(text, offset, len).toLowerCase(), new String(text, offset, len).toLowerCase());

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
