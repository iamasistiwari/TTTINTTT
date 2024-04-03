package TTTINTTT;

import java.util.Scanner;

public class TTTINTTT {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        char [][][] board = new char [9][3][3];
        int moves=0;



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
                gameover = haveWon(board, player);
                moves++;
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
    }
    private static boolean haveWon(char[][][] board, char player){

    }



}
