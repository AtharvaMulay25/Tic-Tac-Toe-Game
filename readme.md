# **Tic-Tac-Toe Game**     

A simple player Vs player version of Tic-Tac-Toe game implemented in OOPs way which can be played on terminal.
The game begins with a msg - "Welcome To TicTacToe Game", generated using Figlet npm package.

## Game Demo
https://user-images.githubusercontent.com/100485953/222427621-2be82570-5aa3-4173-8dc7-355a53c18049.mp4

## Usage
Locate the program TicTacToe.java in your device first by changing the directory to src.
Open the terminal in this directory src
>*For compiling the program*

    javac Player.java Board.java TicTacToe.java
This would create Player.class Board.class TicTacToe.class file in the current directory.

>*For running the program TicTacToe.java (main file)*

    java TicTacToe  

## Assumptions in the game:
- By default, Player1's choice is X, Player2's choice is O.
- Already occupied location on the board cannot be accepted as a move.

## Game-Details
It asks for players names first. Then game continues to ask both the players their moves after every alternate turn. Whenever any player wins the game or if it is a tie, then a display message comes accordingly. It then asks for the new game