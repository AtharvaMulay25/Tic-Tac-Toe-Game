/* 
Created on Wed March 1, 2023
@author: AtharvaMulay25
*/
import java.util.Scanner;


public class TicTacToe {

    //This is the main function, which creates instance of Board Class and Player Class and executes the game 
    public static void main(String[] args) {
        
        printGameTitle();

        //get Players Details
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Player1 name: ");
        String name1 = sc.next();
        System.out.println("Enter Player2 name: ");
        String name2 = sc.next();

        char choice;    //stores newGameChoice
        do
        {
                Player p1 = new Player(name1, 'X');     //p1's choice is set to X
                Player p2 = new Player(name2, 'O');     //p2's choice is set to O
                Board board = new Board();


                boolean gameIsOn = true;
                while(gameIsOn)
                {
                    gameIsOn = p1.move(board);      //executes p1's move
                    if(!gameIsOn) break;
                    gameIsOn = p2.move(board);      //executes p2's move
                }   

                //asking for the next game
                while(true)   
                {
                    System.out.print("\n\nNew Game [Y/N]? : ");
                    choice= sc.next().charAt(0);
                    if(choice == 'Y' || choice == 'N') break;
                }
                

        }while(choice == 'Y');    

    }
    //It prints the Welcome message at the starting of the game    
    public static void printGameTitle()
    {
            //can use feddit to display the intro message welcome to the game
            System.out.println("       __        __   _                               _____     ");
            System.out.println("       \\ \\      / /__| | ___ ___  _ __ ___   ___     |_   _|__");
            System.out.println("        \\ \\ /\\ / / _ \\ |/ __/ _ \\| '_ ` _ \\ / _ \\      | |/ _ \\");
            System.out.println("         \\ V  V /  __/ | (_| (_) | | | | | |  __/      | | (_) |");
            System.out.println("          \\_/\\_/ \\___|_|\\___\\___/|_| |_| |_|\\___|      |_|\\___/");
    
            System.out.println(" _____ _         _____             _____             ____");
            System.out.println("|_   _(_) ___   |_   _|_ _  ___   |_   _|__   ___   / ___| __ _ _ __ ___   ___"); 
            System.out.println("  | | | |/ __|____| |/ _` |/ __|____| |/ _ \\ / _ \\ | |  _ / _` | '_ ` _ \\ / _ \\");
            System.out.println("  | | | | (_|_____| | (_| | (_|_____| | (_) |  __/ | |_| | (_| | | | | | |  __/");
            System.out.println("  |_| |_|\\___|    |_|\\__,_|\\___|    |_|\\___/ \\___|  \\____|\\__,_|_| |_| |_|\\___|");
            System.out.println();
            System.out.println();
    }
}