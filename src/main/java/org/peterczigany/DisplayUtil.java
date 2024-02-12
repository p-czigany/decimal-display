package org.peterczigany;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class DisplayUtil {
  public static void main(String[] args) {
    // Check if proper arguments are provided
    if (args.length < 1 || args.length > 2) {
      System.out.println("Usage: java CommandLineFileCopy <sourceFilePath> [<targetFilePath>]");
      return;
    }

    String sourceFilePath = args[0];
    String targetFilePath = null;

    // If a second argument is provided, set targetFilePath
    if (args.length == 2) {
      targetFilePath = args[1];
    }

    // Read from source file and print to stdout or copy to target file
    try (BufferedReader reader = new BufferedReader(new FileReader(sourceFilePath))) {
      if (targetFilePath == null) {
        String line;
        while ((line = reader.readLine()) != null) {
          System.out.println(line);
        }
      } else {
        try (FileWriter writer = new FileWriter(targetFilePath)) {
          String line;
          while ((line = reader.readLine()) != null) {
            writer.write(line + "\n");
          }
          System.out.println("File copied successfully to " + targetFilePath);
        } catch (IOException e) {
          System.err.println("Error writing to target file: " + e.getMessage());
        }
      }
    } catch (IOException e) {
      System.err.println("Error reading from source file: " + e.getMessage());
    }
  }
}