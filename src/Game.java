import java.util.Scanner;

public class Game {

    static void printBoard(char [][] board)
    {
        for(int i=0 ; i<3 ; i++)
        {
            System.out.print("|");
            for(int j=0 ; j<3 ; j++)
            {
                System.out.print(board[i][j]+"|");
            }
            System.out.println();
        }
    }

    static boolean Won(char [][] board, char currentPlayer)
    {
        // checking each row
        for(int i=0 ; i<3 ; i++)
        {
            if(board[i][0]==currentPlayer && board[i][1]==currentPlayer && board[i][2]==currentPlayer)
            {
                return true;
            }
        }

        // checking each column
        for(int j=0 ; j<3 ; j++)
        {
            if(board[2][j]==currentPlayer && board[1][j]==currentPlayer && board[0][j]==currentPlayer)
            {
                return true;
            }
        }

        //checking diagonal
        if(board[0][0]==currentPlayer&&board[1][1]==currentPlayer&&board[2][2]==currentPlayer)
        {
            return true;
        }

        if(board[0][2]==currentPlayer&&board[1][1]==currentPlayer&&board[2][0]==currentPlayer)
        {
            return true;
        }

        return false;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        char [][] board = new char[3][3];
        char currentPlayer = 'X';

        for(int i=0 ; i<3 ; i++)
        {
            for(int j=0 ; j<3 ; j++)
            {
                board[i][j] = ' ';
            }
        }

        System.out.println("🌟Welcome to the game.🌟");
        printBoard(board);

        while(Won(board,currentPlayer)!=true)
        {
            System.out.print(currentPlayer+"'s turn.Enter Coordinates : ");
            int a = sc.nextInt();
            int b = sc.nextInt();
            if(board[a][b]==' ')
            {
                board[a][b] = currentPlayer;
                printBoard(board);

                // check whether current player on or not
                if(Won(board,currentPlayer)==true)
                {
                    System.out.println(currentPlayer+" won the game🎉🌟.");
                    break;
                }

                // also change players turn
                if(currentPlayer=='X')
                {
                    currentPlayer='O';
                }
                else
                {
                    currentPlayer='X';
                }
            }
            else
            {
                System.out.println("Invalid move, try again!");
            }
        }
    }
}
