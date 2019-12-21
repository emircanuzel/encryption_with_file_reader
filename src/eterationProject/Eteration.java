package eterationProject;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Eteration {
  public static void main(String args[]) throws IOException {

    List<String> lineList= new ArrayList();
    File input = new File("input.txt");
    FileReader fileReader = new FileReader(input);
    String line;
    String[] splitLines;
    String combineline="";

    BufferedReader readFile = new BufferedReader(fileReader);

    while ((line = readFile.readLine()) != null) {

//      System.out.println(line);
      splitLines= line.split(" ");


      for (int i =0; i<splitLines.length;i++){
        if(i%2==0){
          combineline=combineline+splitLines[i]+" ";
        }else{
          combineline=combineline+encriptionString(splitLines[i])+" ";
        }
      }
      lineList.add(combineline);
      combineline="";

    }

    readFile.close();

    writeFileService(lineList);
  }

  private static String encriptionString(String text) {

    String result="";
    for(int i=text.length()-1;i>=0;i--)
    {
     result=result+text.charAt(i);
    }
    return result;
  }


  private static void writeFileService(List<String> s){
    File file = new File("input_result.txt");

    try(BufferedWriter writeFile = new BufferedWriter(new FileWriter(file))) {
      for(int i=0; i<s.size();i++){
        writeFile.write(s.get(i));
        writeFile.newLine();

      }

    }
    catch (IOException e) {
      System.out.println("Read exception " +file.toString());
    }
  }
}
