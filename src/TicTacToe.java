import java.util.Scanner;
public class TicTacToe {
    public static char[][] board = new char[3][3];
    public static void main(String [] args){
        printBoard();
        int turn = 0;
        while((checkWin() == false)&&(checkFull() == false)){
            if (turn % 2 == 0){
                addX();
            }
            else{
                addY();
            }
            turn++;
        }
        System.out.println("Game Over!");

    }
    public static void printBoard(){
        for(int i = 0; i <3; i++){
            for (int j = 0; j<3; j ++){

                System.out.print(board[i][j]);
                if (j == 2){
                    System.out.println();
                }

            }
        }
    }
    public static void addX(){
        int x = 0;
        int y = 0;
        do{
            Scanner in = new Scanner(System.in);
            System.out.print("Row for X: ");
            x = in.nextInt();
            System.out.print("Column for X: ");
            y = in.nextInt();
        }while((board[x][y]== 'X') || (board[x][y]=='O'));
        board[x][y] = 'X';
        printBoard();
    }
    public static void addY(){
        int x = 0;
        int y = 0;
        do{
            Scanner in = new Scanner(System.in);
            System.out.print("Row for O: ");
            x = in.nextInt();
            System.out.print("Column for O: ");
            y = in.nextInt();
        }while((board[x][y]== 'X') || (board[x][y]=='O'));
        board[x][y] = 'O';
        printBoard();
    }
    public static boolean checkWin(){
        int count = 0;
        for(int i = 0; i<3; i++){
            for(int j = 0; j <3; j++){
                if(board[i][j] == 'X'){
                    count ++;
                }
                else if(board[i][j] == 'O'){
                    count --;
                }
                if(j == 2){
                    if(count == 3){
                        return true;
                    }
                    else if (count == -3){
                        return true;
                    }
                    else{
                        count = 0;
                    }
                }
            }
        }
        for(int j = 0; j<3; j++){
            for(int i = 0; i <3; i++){
                if(board[i][j] == 'X'){
                    count ++;
                }
                else if(board[i][j] == 'O'){
                    count --;
                }
                if(i == 2){
                    if(count == 3){
                        return true;
                    }
                    else if (count == -3){
                        return true;
                    }
                    else{
                        count = 0;
                    }
                }
            }
        }
        for(int i =0; i<3; i++){
            if(board[i][i] == 'X'){
                count ++;
            }
            else if (board[i][i] == 'O'){
                count --;
            }
        }
        if(count == 3){
            return true;
        }
        if (count == -3){
            return true;
        }
        else{
            count = 0;
        }
        for(int i = 0; i<3; i++){
            if(board[i][2-i]=='X'){
                count ++;
            }
            else if(board[i][2-i]=='O'){
                count --;
            }
        }
        if(count == 3){
            return true;
        }
        if (count == -3){
            return true;
        }
        return false;

    }
    public static boolean checkFull()
    {

        for (int i = 0; i < 3; i++)
        {
            for(int j =0; j < 3; j++)
            {
                if (board[i][j] == 0)
                {
                    return false;
                }
            }
        }
        return true;
    }
}
