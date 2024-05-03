package TTTINTTT;
import java.util.InputMismatchException;
import java.util.Scanner;

public class TTTINTTT {

    private static int moves = 0;
    public static void main(String[] args) {
        // for input scanner is added
        Scanner in = new Scanner(System.in);

        // Big board of 9X3X3
        char [][][] board = new char [9][3][3];

        // marking blank each boxes and its element
        for(int i = 0; i < 9; i++){
            for (int row = 0; row < 3; row++) {
                for (int col = 0; col < 3; col++) {
                    board[i][row][col] = ' ';
                }
            }
        }
        // we only check the game-over when at-least 18 moves played.
        print(board);
        int mboard = -1;
        while(mboard == -1){
            System.out.print("Which board you want to start with : ");
            try {
                mboard = in.nextInt();
                if(mboard < -1 || mboard >= 9){
                    System.out.println("Invalid board");
                    mboard = -1;
                }
            } catch (InputMismatchException e) {
                System.out.println("Input mismatch! Please enter a valid integer.");
                // Clear the input buffer to avoid infinite loop
                in.next(); // Consume the invalid input
            }
        }
        char player = 'X';
        boolean firstMove = false;
        boolean gameOver = false;
        while(mboard < 9 && !gameOver){
            int checkTime = 0;
            print(board);
            System.out.println();
            int row = -1;
            int col = -1;
            while(row == -1 && col == -1){
                System.out.println("Enter player "+"'"+player+"'"+" move in board "+mboard+" : ");
                try{
                    row = in.nextInt();
                    col = in.nextInt();
                }catch(InputMismatchException e){
                    System.out.println("Input mismatch! Please enter a valid integer.");
                    System.out.println();
                    in.next();
                    print(board);
                }
            }

            if(!firstMove){
                if(mboard == 0 && row == 0 && col == 0){
                    System.out.println("You can't choose same board for other player at first time");
                    checkTime++;

                }
                else if(mboard == 1 && row == 0 && col == 1){
                    System.out.println("You can't choose same board for other player at first time");
                    checkTime++;
                }
                else if(mboard == 2 && row == 0 && col == 2){
                    System.out.println("You can't choose same board for other player at first time");
                    checkTime++;
                }
                else if(mboard == 3 && row == 1 && col == 0){
                    System.out.println("You can't choose same board for other player at first time");
                    checkTime++;
                }
                else if(mboard == 4 && row == 1 && col == 1){
                    System.out.println("You can't choose same board for other player at first time");
                    checkTime++;
                }
                else if(mboard == 5 && row == 1 && col == 2){
                    System.out.println("You can't choose same board for other player at first time");
                    checkTime++;
                }
                else if(mboard == 6 && row == 2 && col == 0){
                    System.out.println("You can't choose same board for other player at first time");
                    checkTime++;
                }
                else if(mboard == 7 && row == 2 && col == 1){
                    System.out.println("You can't choose same board for other player at first time");
                    checkTime++;
                }
                else if(mboard == 8 && row == 2 && col == 2){
                    System.out.println("You can't choose same board for other player at first time");
                    checkTime++;
                }else{
                    firstMove = true;
                }
            }
            if(row < 3 && col < 3 && board[mboard][row][col] == ' ' && checkTime == 0){
                board[mboard][row][col] = player;
                moves++;
                if(moves > 4){
                    gameOver = haveWon(board, player);
                }
                if(gameOver){
                    System.out.println("Congratulations Player '"+player+"' Have won the game");
                    System.out.println();
                }else{
                    player = player == 'X' ? '0' : 'X';
                    if(row == 0){
                        mboard = col;
                    }
                    if (row == 1){
                        mboard = col+3;
                    }
                    if (row == 2){
                        mboard = col+6;
                    }
                    if(moves == 81){
                        System.out.println("Game is Tie Well Played");
                        break;
                    }
                }
            }else{
                System.out.println("Invalid move");
                System.out.println();
            }
        }
        print(board);
    }

    // used to store who won mini-game
    private static char m0WP = '1';
    private static char m1WP = '1';
    private static char m2WP = '2';
    private static char m3WP = '3';
    private static char m4WP = '4';
    private static char m5WP = '5';
    private static char m6WP = '6';
    private static char m7WP = '7';
    private static char m8WP = '8';

    // first check mini board
    private static boolean m0 = false;
    private static boolean m1 = false;
    private static boolean m2 = false;
    private static boolean m3 = false;
    private static boolean m4 = false;
    private static boolean m5 = false;
    private static boolean m6 = false;
    private static boolean m7 = false;
    private static boolean m8 = false;

    private static boolean haveWon(char[][][] board, char player){

        // like if anyone won mini-board it doesn't going to check anymore.
        if (!m0){
            m0 = MiniBoardWon(player, 0, board);
            // this is used to know who won the game
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
            if(m6){
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

        // checking whole game won
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
        return m2WP == player && m4WP == player && m6WP == player;
    }
    private static boolean MiniBoardWon(char player, int mboard, char[][][] board){
        // check row wise
        for (int i = 0; i < 3; i++) {
            if(board[mboard][i][0] == player && board[mboard][i][1] == player && board[mboard][i][2] == player){
                return true;
            }
        }
        // check col wise
        for (int i = 0; i < 3; i++) {
            if(board[mboard][0][i] == player && board[mboard][1][i] == player && board[mboard][2][i] == player){
                return true;
            }
        }
        // check diagonalWise
        if(board[mboard][0][0] == player && board[mboard][1][1] == player && board[mboard][2][2] == player){
            return true;
        }
        return board[mboard][0][2] == player && board[mboard][1][1] == player && board[mboard][2][0] == player;
    }
    private static void print(char[][][] board){
        System.out.println("\t\t\t\tTotal Moves = "+moves);
        System.out.println();
        //tictactoe [0, 1, 2]
        System.out.print("| "+board[0][0][0]+"|"+board[0][0][1]+" |"+board[0][0][2]+" |\t\t");
        System.out.print("| "+board[1][0][0]+"|"+board[1][0][1]+" |"+board[1][0][2]+" |\t\t");
        System.out.print("| "+board[2][0][0]+"|"+board[2][0][1]+" |"+board[2][0][2]+" |\t\t");
        System.out.println();
        System.out.print("| "+board[0][1][0]+"|"+board[0][1][1]+" |"+board[0][1][2]+" |\t\t");
        System.out.print("| "+board[1][1][0]+"|"+board[1][1][1]+" |"+board[1][1][2]+" |\t\t");
        System.out.print("| "+board[2][1][0]+"|"+board[2][1][1]+" |"+board[2][1][2]+" |\t\t");
        System.out.println();
        System.out.print("| "+board[0][2][0]+"|"+board[0][2][1]+" |"+board[0][2][2]+" |\t\t");
        System.out.print("| "+board[1][2][0]+"|"+board[1][2][1]+" |"+board[1][2][2]+" |\t\t");
        System.out.print("| "+board[2][2][0]+"|"+board[2][2][1]+" |"+board[2][2][2]+" |\t\t");
        System.out.println();
        System.out.print(" Board 0"+"\t\t  Board 1 \t      Board 2\t  ");
        if(m0WP != '1'){
            System.out.print(" | '"+m0WP+"' won board 0 | ");
        }
        if(m1WP != '1'){
            System.out.print(" | '"+m1WP+"' won board 1 | ");
        }
        if(m2WP != '2'){
            System.out.print(" | '"+m2WP+"' won board 2 | ");
        }
        System.out.println();
        System.out.println();
        //tictactoe [3, 4, 5]
        System.out.print("| "+board[3][0][0]+"|"+board[3][0][1]+" |"+board[3][0][2]+" |\t\t");
        System.out.print("| "+board[4][0][0]+"|"+board[4][0][1]+" |"+board[4][0][2]+" |\t\t");
        System.out.print("| "+board[5][0][0]+"|"+board[5][0][1]+" |"+board[5][0][2]+" |\t\t");
        System.out.println();
        System.out.print("| "+board[3][1][0]+"|"+board[3][1][1]+" |"+board[3][1][2]+" |\t\t");
        System.out.print("| "+board[4][1][0]+"|"+board[4][1][1]+" |"+board[4][1][2]+" |\t\t");
        System.out.print("| "+board[5][1][0]+"|"+board[5][1][1]+" |"+board[5][1][2]+" |\t\t");
        System.out.println();
        System.out.print("| "+board[3][2][0]+"|"+board[3][2][1]+" |"+board[3][2][2]+" |\t\t");
        System.out.print("| "+board[4][2][0]+"|"+board[4][2][1]+" |"+board[4][2][2]+" |\t\t");
        System.out.print("| "+board[5][2][0]+"|"+board[5][2][1]+" |"+board[5][2][2]+" |\t\t");
        System.out.println();
        System.out.print(" Board 3"+"\t\t  Board 4 \t      Board 5\t  ");
        if(m3WP != '3'){
            System.out.print(" | '"+m3WP+"' won board 3 | ");
        }
        if(m4WP != '4'){
            System.out.print(" | '"+m4WP+"' won board 4 | ");
        }
        if(m5WP != '5'){
            System.out.print(" | '"+m5WP+"' won board 5 | ");
        }
        System.out.println();
        System.out.println();
        //tictactoe [6, 7, 8]
        System.out.print("| "+board[6][0][0]+"|"+board[6][0][1]+" |"+board[6][0][2]+" |\t\t");
        System.out.print("| "+board[7][0][0]+"|"+board[7][0][1]+" |"+board[7][0][2]+" |\t\t");
        System.out.print("| "+board[8][0][0]+"|"+board[8][0][1]+" |"+board[8][0][2]+" |\t\t");
        System.out.println();
        System.out.print("| "+board[6][1][0]+"|"+board[6][1][1]+" |"+board[6][1][2]+" |\t\t");
        System.out.print("| "+board[7][1][0]+"|"+board[7][1][1]+" |"+board[7][1][2]+" |\t\t");
        System.out.print("| "+board[8][1][0]+"|"+board[8][1][1]+" |"+board[8][1][2]+" |\t\t");
        System.out.println();
        System.out.print("| "+board[6][2][0]+"|"+board[6][2][1]+" |"+board[6][2][2]+" |\t\t");
        System.out.print("| "+board[7][2][0]+"|"+board[7][2][1]+" |"+board[7][2][2]+" |\t\t");
        System.out.print("| "+board[8][2][0]+"|"+board[8][2][1]+" |"+board[8][2][2]+" |\t\t");
        System.out.println();
        System.out.print(" Board 6"+"\t\t  Board 7 \t      Board 8\t  ");
        if(m6WP != '6'){
            System.out.print(" | '"+m6WP+"' won board 6 | ");
        }
        if(m7WP != '7'){
            System.out.print(" | '"+m7WP+"' won board 7 | ");
        }
        if(m8WP != '8'){
            System.out.print(" | '"+m8WP+"' won board 8 | ");
        }
        System.out.println();
        System.out.println();
    }
}