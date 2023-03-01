
class Board
{
    char board[][] = new char[3][3];        //stores game board content
    
    //Constructor
    public Board()
    {
        this.clearTerminal();
        this.initialiseBoard();        
        this.drawReferenceBoard();
        this.printBoard();
    }
    //clears the terminal screen
    public void clearTerminal()
    {
        System.out.print("\033[H\033[2J");  //escape code to clear the terminal
        System.out.flush();
    }
    //draws the reference board showing positions
    public void drawReferenceBoard()
    {   
        System.out.println(" _____ _         _____             _____             ");
        System.out.println("|_   _(_) ___   |_   _|_ _  ___   |_   _|__   ___   "); 
        System.out.println("  | | | |/ __|    | |/ _` |/ __|    | |/ _ \\ / _ \\ ");
        System.out.println("  | | | | (__     | | (_| | (__     | | (_) |  __/ ");
        System.out.println("  |_| |_|\\___|    |_|\\__,_|\\___|    |_|\\___/ \\___|  ");
        System.out.println();
        System.out.println("REFERENCE BOARD SHOWING POSITIONS ===>");
        String refBoard[] = {" 1 | 2 | 3 ", "---|---|---", " 4 | 5 | 6 ", "---|---|---", " 7 | 8 | 9 "};
        for(int i=0;i<5;i++)
        {
            System.out.print("\t\t\t");
            System.out.println(refBoard[i]);
        }
        System.out.println();
    }
    //initialises board as empty board
    public void initialiseBoard()
    {
        for(int r=0; r<3;r++)
        {
            for(int c=0;c<3;c++)
            {
                this.board[r][c] = ' ';
            }
        }
    }
    //checks if any player has won the game
    public int isGameOver()
    {
        for(int i=0;i<3;i++)
        {
            if((this.board[i][0] == this.board[i][1]) && (this.board[i][1] == this.board[i][2]) && this.board[i][0]!= ' ')
            {
                
                return 1;
            }
        }
        for(int j=0;j<3;j++)
        {
            if((this.board[0][j] == this.board[1][j]) && (this.board[1][j] == this.board[2][j])  && this.board[0][j]!= ' ') 
            {
                return 1;
            }
        }

        if((this.board[0][0] == this.board[1][1]) && (this.board[1][1] == this.board[2][2]) && this.board[0][0]!= ' ')
        {
            return 1;
        }
        if((this.board[0][2] == this.board[1][1]) && (this.board[1][1] == this.board[2][0]) && this.board[1][1]!= ' ')
        {
            return 1;
        }

        for(int i=0;i<3;i++)
        {
            for(int j=0;j<3;j++)
            {
                if(this.board[i][j] == ' ')
                {
                    return 0;   
                }
            }
        }            
        return -2; //there is a tie
    }
    //updates the board after every turn
    public int updateBoard(int row, int col, char choice)
    {   
        if(board[row][col] != ' ')
        {
            System.out.println("This Location is already Occupied!!! Chosse a different one.");
            return -1;
        }
       
        this.board[row][col] = choice;
            
        
        return this.isGameOver();
    }   

    //prints the board after every turn
    public void printBoard()
    {
        this.clearTerminal();
        this.drawReferenceBoard();
        System.out.println("GAME BOARD ===>");
        for(int i=0;i<3;i++)
        {                   
            System.out.print("\t\t\t ");
            for(int j=0;j<3;j++)
            {             
                System.out.print(this.board[i][j]);
                if(j<2)
                {
                    System.out.print(" | ");
                }
            }
            System.out.println();
            if(i<2)
            {   
                System.out.print("\t\t\t");
                for(int dashes = 0; dashes<11;dashes++)
                {   
                    if((dashes+1)%4 == 0) System.out.print("|");
                    else  System.out.print("-");
                }
            }
            System.out.println();
        }            
    }

}
