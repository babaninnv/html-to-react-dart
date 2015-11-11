package ru.babaninnv.translator.html.react.dart;

import com.beust.jcommander.Parameter;

public class Cli {

  @Parameter(names = {"-h", "--help"}, help = true)
  private boolean help;

  @Parameter(names = "-file", required = true, description = "File *.html for parsing. Required")
  private String fileName;

  @Parameter(names = "-out", required = false, description = "Output folder. Default: current folder. Optional")
  private String outputFolder = "";

  @Parameter(names = "-wrap-class", required = false, description = "It wraps converted DOM tree is Dart class infrastructure. Default it use name from '-file' value. Optional")
  private Boolean wrapClass = false;

  @Parameter(names = "-class-name", required = false, description = "If you use '-wrap-class' it parameter set class name for class wrapper. Value is class name in upper camel case style. Ex.: ReactDartClass. Optional")
  private String className = "";

  public String getFileName() {
    return fileName;
  }

  public String getOutputFolder() {
    return outputFolder;
  }

  public Boolean getWrapClass() {
    return wrapClass;
  }

  public String getClassName() {
    return className;
  }
}
