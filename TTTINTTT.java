package TTTINTTT;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

public class TTTINTTT {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        char [][][] board = new char [9][3][3];

        for(int i = 0; i < 9; i++){
            for (int row = 0; row < 3; row++) {
                for (int col = 0; col < 3; col++) {
                    board[i][row][col] = ' ';
                }
            }
        }


        int moves = 0;
        System.out.print("which board you want to start with : ");
        int mboard = in.nextInt();
        char player = 'X';
        boolean gameover = false;
        while(!gameover){
            print(board);
            System.out.println("Enter your move in board"+mboard+" : ");
            int row = in.nextInt();
            int col = in.nextInt();
            if(board[mboard][row][col] == ' '){
                board[mboard][row][col] = player;
                moves++;
                if(moves > 20){
                    gameover = haveWon(board, player);
                }
                if(gameover){
                    System.out.println(player+"Have won the game");
                }else{
                    player = player == 'X' ? '0' : 'X';
                    mboard = col;

                }
            }else{
                System.out.println("Invalid move");
            }
        }
        print(board);
    }
    private static boolean haveWon(char[][][] board, char player){
        // first check mini board
        boolean m0 = false;
        boolean m1 = false;
        boolean m2 = false;
        boolean m3 = false;
        boolean m4 = false;
        boolean m5 = false;
        boolean m6 = false;
        boolean m7 = false;
        boolean m8 = false;
        if (!m0){
            m0 = MiniBoardWon(player, 0, board);
        }
        if (!m1){
            m1 = MiniBoardWon(player, 1, board);
        }
        if (!m2){
            m2 = MiniBoardWon(player, 2, board);
        }
        if (!m3){
            m3 = MiniBoardWon(player, 3, board);
        }
        if (!m4){
            m4 = MiniBoardWon(player, 4, board);
        }
        if (!m5){
            m5 = MiniBoardWon(player, 5, board);
        }
        if (!m6){
            m6 = MiniBoardWon(player, 6, board);
        }
        if (!m7){
            m7 = MiniBoardWon(player, 7, board);
        }
        if (!m8){
            m8 = MiniBoardWon(player, 8, board);
        }


        //checking rowWise
        if(m0 && m1 && m2){
            return true;
        }
        if(m3 && m4 && m5){
            return true;
        }
        if(m6 && m7 && m8){
            return true;
        }

        //checking col wise
        if(m0 && m3 && m6){
            return true;
        }
        if(m1 && m4 && m7){
            return true;
        }
        if(m2 && m5 && m8){
            return true;
        }
        //checking diagonalWise
        if(m0 && m4 && m8){
            return true;
        }
        if(m2 && m4 && m6){
            return true;
        }
        return false;
    }
    private static boolean MiniBoardWon(char player, int board, char[][][] mboard){
        // check row wise
        for (int i = 0; i < 3; i++) {
            if(mboard[board][i][0] == player && mboard[board][i][1] == player && mboard[board][i][2] == player){
                return true;
            }
        }
        // check col wise
        for (int i = 0; i < 3; i++) {
            if(mboard[board][0][i] == player && mboard[board][1][i] == player && mboard[board][2][i] == player){
                return true;
            }
        }
        // check diagonalWise
        if(mboard[board][0][0] == player && mboard[board][1][1] == player && mboard[board][2][2] == player){
            return true;
        }
        if(mboard[board][0][2] == player && mboard[board][1][1] == player && mboard[board][2][0] == player){
            return true;
        }
        return false;
    }
    private static void print(char[][][] board){
        for(int i = 0; i < 9; i++){
            for (int row = 0; row < 3; row++) {
                for (int col = 0; col < 3; col++) {
                    System.out.print(board[i][row][col]+" | ");
                }
                System.out.println();
            }
            System.out.println("Mini board = "+i+1);
        }
    }

}
