package pacman;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class fileConverter {
    public fileConverter(char[][] matrix, int explored, int length){

    try{

            StringBuilder builder = new StringBuilder();
            for(int i = 0; i < matrix.length; i++)//for each row
            {
                for(int j = 0; j < matrix[i].length; j++)//for each column
                {if(matrix[i][j] == '0') {
                    builder.append('%');//if its a wall
                }else if(matrix[i][j] == '1'){
                    builder.append(' ');//if its a path
                }else if(matrix[i][j] == '.'){
                    builder.append('.' );
                }else if((matrix[i][j] == 'P') || (matrix[i][j] =='E')){
                    builder.append('.');
                }
                else if(matrix[i][j] == 'X'){
                    builder.append('X');
                }else if(matrix[i][j] == 'V'){
                    builder.append(' ' );
                }

                }
                builder.append("\n");//append new line at the end of the row
            }
            builder.append("Explored nodes: "+explored + "\n");
            builder.append("Path length: "+length + "\n");

            BufferedWriter writer = new BufferedWriter(new FileWriter("solution.txt"));
            writer.write(builder.toString());
            writer.close();
            System.out.println("Done, Please check solution in solution.txt");
    }

        catch(IOException e){
            System.out.println(e);
        }

    }
}
