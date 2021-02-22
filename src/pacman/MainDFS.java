package pacman;
/*
 * Main method for running DFS
 * 0s are walls 1s are paths
 * Please enter maze file in the MazeReader below
 */

import java.util.*;

import pacman.*;
public class MainDFS {

    public static void main(String args[])
    {   int nodes_explored = 0;
        int path_length = 0;

        //this is where you insert maze
        MazeReader b = new MazeReader("src/pacman/bigMaze.txt");


        char[][] a = b.getArr();
        int start_x = b.getStart_x();
        int start_y = b.getStart_y();
        int end_x = b.getEnd_x();
        int end_y = b.getEnd_y();
        //importing the starting and ending positions to check goal state.

        for (int i = 0; i < a.length; i++)
            System.out.println(Arrays.toString(a[i]));

        char[][] path = depth_first_search(a, start_x, start_y);

        //just to count nodes explored and path length
        for(int i = 0; i < path.length; i++){
            System.out.println(Arrays.toString(path[i]));
            for(int j =0; j< path.length; j++){
                if(path[i][j] == 'P'){ path_length++; nodes_explored ++;}
                else if(path[i][j] == 'V') nodes_explored ++;
            }
        }
        System.out.println("Explored nodes: " + nodes_explored);
        System.out.println("Path length: " + path_length);
        /*------------------------------------------------*/

        fileConverter solution = new fileConverter(path,nodes_explored,path_length);

    }

    public static char[][] depth_first_search(char[][] matrix, int start_x, int  start_y) {

        //how many rows it has
        int N = matrix.length;

        Stack<Node> stack = new Stack<Node>();
        stack.push(new Node(start_x, start_y, null)); //insert starting position node <- want to mark visited and check neighbours

        while(!stack.isEmpty()) { //not empty
            Node current = stack.peek(); //peek first
            //just to see the path
            stack.pop();
            if(matrix[current.x][current.y] ==  'E') {//once it reaches end

                while(current.prev != null){
                    System.out.println("[" + current.prev.x + "," + current.prev.y +"]");
                    matrix[current.prev.x][current.prev.y] = 'P';
                    current = current.prev;
                }
                break;
            }


            matrix[current.x][current.y] = 'V'; // mark as visited

            Collection<Node> neighbors = getNeighbors(matrix, current); //now we check neighbours, pass current node

            stack.addAll(neighbors);
        }

        return matrix;
    }
    //using a collection
    public static Collection<Node> getNeighbors(char[][] matrix, Node current) {
        Collection<Node> neighbors = new Stack<Node>(); //create list of neighbours
        //up
        if(isValid(matrix, current.x - 1, current.y)) {
            neighbors.add(new Node(current.x - 1, current.y,current));
        }
        //left
        if(isValid(matrix, current.x, current.y - 1)) {
            neighbors.add(new Node(current.x, current.y - 1,current));
        }

        //right
        if(isValid(matrix, current.x, current.y + 1)) {
            neighbors.add(new Node(current.x, current.y + 1,current));
        }
        //down
        if(isValid(matrix, current.x + 1, current.y)) {
            neighbors.add(new Node(current.x + 1, current.y,current));
        }


        return neighbors;
    }
    //pass matrix and the coords
    public static boolean isValid(char[][] matrix, int x, int y) {
        //not visited and not wall
        return !(x < 0 || x >= matrix.length || y < 0 || y >= matrix.length) && (matrix[x][y] != '0') && (matrix[x][y] != 'V');
        //x and y pos can't be negative , out of bounds and can't be greater than length of matrix
    }

}
