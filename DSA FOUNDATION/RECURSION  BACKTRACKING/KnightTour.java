import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int arr[][] = new int[n][n];
        int row = scn.nextInt();
        int col = scn.nextInt();
        printKnightsTour(arr, row, col, 1);
    }

    public static void printKnightsTour(int[][] chess, int row, int col, int upc) {
       
        if (row < 0 || row >= chess.length || col < 0 || col >= chess[0].length) {
            return;
        }

        if (chess[row][col] != 0) {
            return;
        }
        
        if (upc == (chess.length * chess[0].length)) {
            chess[row][col]=upc;
            displayBoard(chess);
            chess[row][col]=0;
            return;
        }
        
        chess[row][col] = upc;


        // 1 upward right
        printKnightsTour(chess, row - 2, col + 1, upc + 1);
        // 2 right upward
        printKnightsTour(chess, row - 1, col + 2, upc + 1);
        // 3 right down
        printKnightsTour(chess, row + 1, col + 2, upc + 1);
        // 4 downword right
        printKnightsTour(chess, row + 2, col + 1, upc + 1);
        // 5 downword left
        printKnightsTour(chess, row + 2, col - 1, upc + 1);
        // 6 left down
        printKnightsTour(chess, row + 1, col - 2, upc + 1);
        // 7 left  up
        printKnightsTour(chess, row - 1, col - 2, upc + 1);
        // 8 top left
        printKnightsTour(chess, row - 2, col - 1, upc + 1);
        
        chess[row][col] = 0; 
        




    }

    public static void displayBoard(int[][] chess) {
        for (int i = 0; i < chess.length; i++) {
            for (int j = 0; j < chess[0].length; j++) {
                System.out.print(chess[i][j] + " ");
            }
            System.out.println();
        }

        System.out.println();
    }
}