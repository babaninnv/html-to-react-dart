package ru.babaninnv.translator.html.react.dart;

import com.beust.jcommander.Parameter;

public class Cli {

  @Parameter(names = "-file", required = true, description = "Parse file")
  private String fileName;

  @Parameter(names = "-out", required = false, description = "Output folder. Default: current")
  private String outputFolder = "";

  public String getFileName() {
    return fileName;
  }

  public String getOutputFolder() {
    return outputFolder;
  }
}
