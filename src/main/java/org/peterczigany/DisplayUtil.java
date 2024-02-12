package org.peterczigany;

import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.math.BigDecimal;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class DisplayUtil {
  public static void main(String[] args) {
    if (args.length < 1 || args.length > 2) {
      System.out.println("Usage: java DisplayUtil <sourceFilePath> [<targetFilePath>]");
      return;
    }

    try {
      List<String> lines = readLines(args[0]);
      if (args.length == 1) {
        printToStdout(lines);
      } else {
        try {
          writeToFile(lines, args[1]);
        } catch (IOException e) {
          System.err.println("Error writing to target file: " + e.getMessage());
        }
      }
    } catch (IOException e) {
      System.err.println("Error reading from source file: " + e.getMessage());
    }
  }

  private static List<String> readLines(String sourceFilePath) throws IOException {
    try (BufferedReader reader = Files.newBufferedReader(Paths.get(sourceFilePath))) {
      return reader.lines().map(DisplayUtil::convert).toList();
    }
  }

  private static void printToStdout(List<String> lines) {
    lines.forEach(System.out::println);
  }

  private static void writeToFile(List<String> lines, String targetFilePath) throws IOException {
    try (FileWriter writer = new FileWriter(targetFilePath)) {
      writer.write(String.join("\n", lines));
      System.out.println("File copied successfully to " + targetFilePath);
    }
  }

  public static String print(BigDecimal number) {
    return number.stripTrailingZeros().toPlainString().replace(".", ",");
  }

  public static String convert(String numberString) {
    return print(new BigDecimal(numberString.replace(",", ".")));
  }
}
