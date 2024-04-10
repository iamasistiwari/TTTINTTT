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
        // we only check the game-over when 20 moves has been done.
        int moves = 0;
        System.out.print("Which board you want to start with : ");
        int mboard = in.nextInt();
        char player = 'X';
        boolean gameover = false;
        while(!gameover){
            print(board);
            System.out.println("Enter your move in board "+mboard+" : ");
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
                    if(row == 0 && col < 3){
                        mboard = col;
                    }
                    if (row == 1 && col < 3 ){
                        mboard = col+3;
                    }
                    if (row == 2 && col < 3){
                        mboard = col+6;
                    }
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
        char m0WP = 'Y';
        char m1WP = 'X';
        char m2WP = '2';
        char m3WP = '3';
        char m4WP = '4';
        char m5WP = '9';
        char m6WP = '6';
        char m7WP = '7';
        char m8WP = '8';
        
        if (!m0){
            m0 = MiniBoardWon(player, 0, board);
            if(m0){
                m0WP = player;
            }
        }
        if (!m1){
            m1 = MiniBoardWon(player, 1, board);
            if(m1){
                m1WP = player;
            }
        }
        if (!m2){
            m2 = MiniBoardWon(player, 2, board);
            if(m2){
                m2WP = player;
            }
        }
        if (!m3){
            m3 = MiniBoardWon(player, 3, board);
            if(m3){
                m3WP = player;
            }
        }
        if (!m4){
            m4 = MiniBoardWon(player, 4, board);
            if(m4){
                m4WP = player;
            }
        }
        if (!m5){
            m5 = MiniBoardWon(player, 5, board);
            if(m5){
                m5WP = player;
            }
        }
        if (!m6){
            m6 = MiniBoardWon(player, 6, board);
            if(m0){
                m6WP = player;
            }
        }
        if (!m7){
            m7 = MiniBoardWon(player, 7, board);
            if(m7){
                m7WP = player;
            }
        }
        if (!m8){
            m8 = MiniBoardWon(player, 8, board);
            if(m8){
                m8WP = player;
            }
        }


        //checking rowWise
        if(m0WP == player && m1WP == player && m2WP == player){
            return true;
        }
        if(m3WP == player && m4WP == player && m5WP == player){
            return true;
        }
        if(m6WP == player && m7WP == player && m8WP == player){
            return true;
        }

        //checking colWise
        if(m0WP == player && m3WP == player && m6WP == player){
            return true;
        }
        if(m1WP == player && m4WP == player && m7WP == player ){
            return true;
        }
        if(m2WP == player && m5WP == player && m8WP == player){
            return true;
        }

        //checking diagonalWise
        if(m0WP == player && m4WP == player && m8WP == player){
            return true;
        }
        if(m2WP == player && m4WP == player && m6WP == player){
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
            System.out.println("Mini board -> "+i);
        }
    }

}
