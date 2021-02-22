package pacman;
/*
 * java class which counts columns and rows of file to put send to maze reader for 2d array
 */
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;

public class fileCount {
    //rows and columns of file
    public static int r = 0;
    public static int c = 0;
    public fileCount(String file){//pass string file txt
        try {
            BufferedReader reader = new BufferedReader(new FileReader(file));
            while(reader.readLine() != null){

                r++;
            }
            //get first line length
            String firstLine = Files.readAllLines(Paths.get(file)).get(0);
            c = firstLine.length();
            //check
            System.out.println("row: " + r);
            System.out.println("col: "+ c);
            reader.close();

        }catch(IOException e){
            System.out.println("no file");
        }

    }
    //get methods
    public int getR(){
        return r;
    }
    public int getC(){
        return c;
    }
}
