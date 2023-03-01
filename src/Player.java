import java.util.Scanner;
import java.util.InputMismatchException;


class Player
{   
    String name;    //player's name
    char choice;    //player's choice 
    Scanner sc = new Scanner(System.in);

    //Constructor
    public Player(String name, char choice)
    {
        this.name = name;        
        this.choice = choice;
    }

    //it asks player's move until it is a valid move and executes it
    public boolean move(Board b)
    {   
        int cell = this.askMove();
        while( cell == -1)
            cell = this.askMove();
        
        return this.executeMove(b, cell);
        
    }
    //it gets player's move (some unoccupied position on the board) and handles errors
    public int askMove()
    {
        System.out.println("Its "+ this.name + "'s move");
        System.out.print("Enter your Desired Location [1:9]: ");

        // System.out.println(cell);
        try{
            int cell =  sc.nextInt();
            if(cell<1 || cell>9)     
            {
                System.out.println("Invalid Location!! Redo the move.");
                return -1;
            }
            return cell;
        }
        catch (InputMismatchException  e) {
            sc.nextLine(); // clears the buffer, this line is important otherwise it will continuously go again n catch considering prev wrong cell value
            System.out.println("Invalid Location!! Redo the move.");
           return -1;
        }   
       
    }

    //it executes the player's move by updating the board
    public boolean executeMove(Board b,int cell)
    {
        int row = (cell - 1)/3;
        int col = (cell-1)%3 ;

        int status = b.updateBoard(row, col, this.choice);
        if(status == -1)
        {
            this.move(b);
        }
        if(status == 1) 
        {
            b.printBoard();
            System.out.println("Congrats!! " + this.name + " wins the game.");
            return false;
        }
        if(status == -2)
        {
            b.printBoard();
            System.out.println("Oops!! The game is a tie.");                
            return false;
        }       
        b.printBoard();   //if stat is 0
        return true;
    }
}

