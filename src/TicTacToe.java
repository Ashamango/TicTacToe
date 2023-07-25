import java.util.Scanner; // import java.util.Scanner;
public class TicTacToe { // class TicTacToe
    private static final int ROW = 3; // private static final int ROW = 3 CONSTANT
    private static final int COL = 3; // private static final int COL = 3 CONSTANT
    private static String board[][] = new String[ROW][COL]; // board array = [ROW] [COL]

    public static void main(String[] args) { // main
        boolean answer = false; // boolean answer = false
        int placementRow; // int placementRow
        int placementCol; // int placementCol
        int moveCount = 0; // int moveCount = 0
        boolean validMove = true; // boolean validMove = true
        boolean tie = true; // boolean tie = true
        String player = ""; // String player = "" empty string
        Scanner in = new Scanner(System.in); // Scanner in = new Scanner(System.in)
        do { // repeats the whole game if answered yes
            // Start of game, clears board and resets it
            clearBoard(); // go to method and clears board
            moveCount = 0; // moveCount = 0
            player = "O"; // player = "O"
            display(); // go to method and display cleared board

            do { // do repeat between X and O until a win or tie
                // goes between X and O
                if(player == "O") // if(player == "O")
                {
                    player = "X"; // player = "X"
                    System.out.println("It is X's turn."); // output "It is X's turn."
                }
                else if (player == "X") // else if (player == "X")
                {
                    player = "O"; // player = "O"
                    System.out.print("It is O's turn."); // output "It is O's turn."
                }

                // loops back if cell is taken
                do { // do
                    placementRow = SafeInput.getRangedInt(in, "What row do you want?", 1, 3); // placement = SafeInput.getRangedInt(in, "What row do you want?", 1, 3)
                    placementCol = SafeInput.getRangedInt(in, "What column do you want?", 1, 3); // placement = SafeInput.getRangedInt(in, "What column do you want?", 1, 3)

                    if (placementRow == 1 && placementCol == 1) //if (placementRow == 1 && placementCol == 1) then
                    {
                        validMove = isValidMove(0, 0); // check if 0,0 is taken up cell

                    }
                    if (placementRow == 1 && placementCol == 2) // if (placementRow == 1 && placementCol == 2) then
                    {
                        validMove = isValidMove(0, 1); // check if 0,1 is taken up cell
                    }
                    if (placementRow == 1 && placementCol == 3) // if (placementRow == 1 && placementCol == 3) then
                    {
                        validMove = isValidMove(0, 2); // check if 0,2 is taken up cell
                    }
                    if (placementRow == 2 && placementCol == 1) // if (placementRow == 2 && placementCol == 1) then
                    {
                        validMove = isValidMove(1, 0); // check if 1,0 is taken up cell
                    }
                    if (placementRow == 2 && placementCol == 2) // if (placementRow == 2 && placementCol == 2) then
                    {
                        validMove = isValidMove(1, 1); // check if 1,1 is taken up cell
                    }
                    if (placementRow == 2 && placementCol == 3) // if (placementRow == 2 && placementCol == 3) then
                    {
                        validMove = isValidMove(1, 2); // check if 1,2 is taken up cell
                    }
                    if (placementRow == 3 && placementCol == 1) // if (placementRow == 3 && placementCol == 1) then
                    {
                        validMove = isValidMove(2, 0); // check if 2,0 is taken up cell
                    }
                    if (placementRow == 3 && placementCol == 2) // if (placementRow == 3 && placementCol == 2) then
                    {
                        validMove = isValidMove(2, 1); // check if 2,1 is taken up cell
                    }
                    if (placementRow == 3 && placementCol == 3) // if (placementRow == 3 && placementCol == 3) then
                    {
                        validMove = isValidMove(2, 2); // check if 2,2 is taken up cell
                    }
                } while (!validMove); // repeat while the cell is not empty

                // passes the validMove check and converts player input to array input
                if (placementRow == 1 && placementCol == 1) //if (placementRow == 1 && placementCol == 1) then
                    board[0][0] = player; // board[0][0] = player

                if (placementRow == 1 && placementCol == 2) // if (placementRow == 1 && placementCol == 2) then
                    board[0][1] = player; // board[0][1] = player

                if (placementRow == 1 && placementCol == 3) // if (placementRow == 1 && placementCol == 3) then
                    board[0][2] = player; // board[0][2] = player

                if (placementRow == 2 && placementCol == 1) // if (placementRow == 2 && placementCol == 1) then
                    board[1][0] = player; // board[1][0] = player

                if (placementRow == 2 && placementCol == 2) // if (placementRow == 2 && placementCol == 2) then
                    board[1][1] = player; // board[1][1] = player

                if (placementRow == 2 && placementCol == 3) // if (placementRow == 2 && placementCol == 3) then
                    board[1][2] = player; // board[1][2] = player

                if (placementRow == 3 && placementCol == 1) // if (placementRow == 3 && placementCol == 1) then
                    board[2][0] = player; // board[2][0] = player

                if (placementRow == 3 && placementCol == 2) // if (placementRow == 3 && placementCol == 2) then
                    board[2][1] = player; // board[2][1] = player

                if (placementRow == 3 && placementCol == 3) // if (placementRow == 3 && placementCol == 3) then
                    board[2][2] = player; // board[2][2] = player

                // display the updated space
                display(); // go to display method
                moveCount = moveCount + 1; // using a counter for the wins, moveCount = moveCount + 1

                // check if there is a win or a tie
                if (moveCount >= 5) // if (moveCount >= 5) then
                {
                    isWin(player); // check if it's a win
                    if (isWin(player) == true) // if (isWin(player) == true) then
                    {
                        System.out.println("Player " + player + " wins!"); // output "Player " + player + " wins!"
                        break; // break and jump out of the loop to go to play again if there is a win
                    }
                }
                    if (moveCount == 9) //  if (moveCount == 9)
                    {
                        tie = isTie(player); // tie = isTie(player)
                        if (tie = true) // if (tie = true) then
                        {
                            System.out.println("A tie!"); // output "A tie!"
                            break; // break
                        }
                    }
                    else if (moveCount == 7) // else if (moveCount == 7) then
                    {
                        tie = isTie(player); // tie = isTie(player)
                        if (tie = true) // if (tie = true) then
                        {
                            System.out.println("A tie!"); // output"A tie!"
                            break; // break
                        }
                    }

            } while (!isWin(player)|!isTie(player)); // while (!isWin(player)|!isTie(player)); while there is not a win nor tie
            answer = SafeInput.getYNConfirm(in, "Do you want to play again "); // answer = SafeInput.getYNConfirm(in, "Do you want to play again "
        }  while (!answer); // while answer is false
    } // return

    // clear the board for new game
    private static void clearBoard() // sets all in board elements to a space
    {
        for (int row = 0; row < ROW; row++) // for (int row = 0; row < ROW; row++)
        {
            for (int col = 0; col < COL; col++) // for (int col = 0; col < COL; col++)
            {
                board[row][col] = " "; // make this cell a space
            } // end for
        } // end for
        System.out.println("It is X's turn."); // at start of game is X's turn, output "It is X's turn."

    }

    // Show the board for game
    private static void display() // shows the Tic Tac Toe game used as part of the prompt for the users move choice
    {
        for (int row = 0; row < ROW; row++) // for (int row = 0; row < ROW; row++)
        {

            for (int col = 0; col < COL; col++) // for (int col = 0; col < COL; col++)
            {
                System.out.print(board[row][col] + " | "); // System.out.print(board[row][col] + " | ") appearance
            } // end for
            System.out.println(); // System.out.println() new line

            for (int col = 0; col < 1; col++) // for (int col = 0; col < 1; col++)
            {
                System.out.print("-------------"); // System.out.print("-------------") in between
            } // end for
            System.out.println(); // System.out.println() new line
        } // end for
    }
    // is the move valid meaning is there an empty space
    private static boolean isValidMove(int row, int col) // returns true if there is a space at the given proposed move coordinates which means it is a legal move.
    {
        if (board[row][col].equals(" ")) // if the if (board[row][col].equals(" ")) then
        {
            return true; // return true
        }
        else // else
        {
            System.out.println("This spot is already taken! Please choose a different spot."); // output "This spot is already taken! Please choose a different spot."
            return false; // return false
        }
    }
    // seeing if there is a win
    private static boolean isWin(String player) // checks to see if there is a win state on the current board for the specified player (X or O) This method in turn calls three additional methods that break down the 3 kinds of wins that are possible.
    {
        if (isColWin(player) || isRowWin(player) || isDiagonalWin(player)) // if (isColWin(player) || isRowWin(player) || isDiagonalWin(player)) then
        {
            return true; // return true

        }
            return false; // return false
    }
    // Col win
    private static boolean isColWin(String player) // checks for a col win for player
    {
        for (int col = 0; col < COL; col++) // for (int col = 0; col < COL; col++)
        {
            if (board[0][col].equals(player) && board[1][col].equals(player) && board[2][col].equals(player)) // if the corresponding row spaces are filled with the same player then
            {
                return true; // return true
            }
        } // end for
        return false; // no row win
    }
    // column win
    private static boolean isRowWin(String player) // checks for a row win for the specified player
    {
        for (int row = 0; row < ROW; row++) // for (int row = 0; row < ROW; row++)
        {
            if (board[row][0].equals(player) && board[row][1].equals(player) && board[row][2].equals(player)) // if the corresponding column spaces are filled with the same player then
            {
                return true; // return true
            }
        } // end for
        return false; // no row win
    }
    // diagonal win
    private static boolean isDiagonalWin(String player) // checks for a diagonal win for the specified player
    {
            if (board[0][0].equals(player) && board[1][1].equals(player) && board[2][2].equals(player)) // if the corresponding diagonal spaces are filled with the same player then
            {
                return true; // return true
            }
            else if (board[0][2].equals(player) && board[1][1].equals(player) && board[2][0].equals(player)) // else if the other corresponding diagonal spaces are filled with the same player then
            {
                return true; // return true;
            }

        return false; // no row win
    }
    // is a tie
    private static boolean isTie(String player) // checks if there is a tie
    {
        for (int row = 0; row < ROW; row++) // for (int row = 0; row < ROW; row++)
        {
            for (int col = 0; col < COL; col++) // for (int col = 0; col < COL; col++)
            {
                if (board[row][col] == " ") // if (board[row][col] == " ") then
                {
                    return false; // return false if there are still spaces
                }
                else if(isColWin("X") && isColWin("0")) // else if(isColWin("X") && isColWin("0")) eliminates isColWin then
                {
                    return true; // return true
                }
                else if(isRowWin("X") && isRowWin("O")) // else if(isRowWin("X") && isRowWin("O")) eliminates isRowWin then
                {
                    return true; // return true
                }
                else if(isDiagonalWin("X") && isDiagonalWin("0")) // else if(isDiagonalWin("X") && isDiagonalWin("0")) eliminates isDiagonalWin then
                {
                    return true; // return true
                }
            } // end for
        } // end for
        return true; // return true
    }
} // end class