import java.util.*;
import java.lang.*;
import java.io.*;
class TicTac
{
    int winflag;
    static Random rand = new Random();
    char[][] board = new char[3][3];
    char winchar;
    public int winner;
    TicTac()
    {
        winflag = 0;
    }
    public static int randBoard()
    {
        return rand.nextInt(3);
    }
    public void setSquares()
    {
        for(int i=0;i<3;i++)
        {
            for(int j=0;j<3;j++)
            {
                board[i][j]='-';
            }
        }
    }
    public void firstInput()
    {
        System.out.println("Welcome to Tic-Tac-Toe!");
        this.setSquares();
        this.printBoard();
        this.player1();
    }
    public void Input()
    {
        this.printBoard();
        this.player1();
    }
    public void printBoard()
    {
        for(int i=0;i<3;i++)
        {
            for(int j=0;j<3;j++)
            {
                System.out.print(board[i][j]+" ");
            }
            System.out.print("\n");
        }
    }
    public void player1()
    {
        int i,j;
        Scanner inp = new Scanner(System.in);
        if(this.winCheck() == false)
        {
            System.out.println("Enter the row [1-3] and column[1-3] to mark 'X':");
            System.out.println("Row:");
            i = inp.nextInt();
            System.out.println("Column:");
            j = inp.nextInt();
            board[i-1][j-1] = 'X'; //Index from 0-2
            this.player2();
        }
        else
        {
            System.out.println("The game is over!");
        }
    }
    public void player2()
    {
        int i = randBoard();
        int j = randBoard();
        while(board[i][j] != '-')
        {
            i = randBoard();
            j = randBoard();
        }
        board[i][j] = 'O';
        this.printBoard();
        this.player1();
    }
    public boolean winCheck()
    {
        //Vertical
        for(int i=0;i<3;i++)
        {
            if(board[i][0] == board[i][1] && board[i][0] == board[i][2] && board[i][0] != '-')
            {
                winflag = 1;
                winchar = board[i][0];
                break;
            }
        }
        //Horizontal
        if(winflag == 0)
        {
            for(int i=0;i<3;i++)
            {
                if(board[0][i] == board[1][i] && board[0][i] == board[2][i] && board[0][i] != '-')
                {
                    winflag = 1;
                    winchar = board[i][0];
                    break;
                }
            }
        }
        //Diagonal
        if(winflag == 0)
        {
            if(board[0][0] == board[1][1] && board[0][0] == board[2][2] && board[0][0] != '-')
            {
                winflag = 1;
                winchar = board[0][0];
            }
        }
        //Last check
        if(winflag == 1)
        {
            if(winchar == 'X')
            {
                winner = 1;
            }
            else
            {
                winner = 2;
            }
            return true;
        }
        else
        {
            return false;
        }
    }
}
public class Game
{
    public static int p1,p2;
    public static char playAgain()
    {
        Scanner inp = new Scanner(System.in);
        TicTac TestBoard = new TicTac();
        TestBoard.firstInput();
        if(TestBoard.winner == 1)
            p1 = p1+1;
        else
            p2 = p2+1;
        System.out.println("Play again? Y/N");
        return inp.next().charAt(0);
    }
    public static void main(String args[])
    {
        char playflag = 'Y';
        while(true)
        {
            playflag = playAgain();
            if(playflag == 'N' || playflag == 'n')
            {
                break;
            }
            else
            {
                continue;
            }
        }
        /*while(playflag != 'N')
        {
            playflag = playAgain();
        }*/
        System.out.println("Player 1: "+p1);
        System.out.println("Player 2: "+p2);
    }
}
