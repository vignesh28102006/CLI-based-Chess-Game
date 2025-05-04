package Main;

import boardGame.*;
import pieces.*;
import Chess.*;
import views.*;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ChessMatch chessMatch = new ChessMatch();
        List<ChessPiece> capturedChessPieces = new ArrayList<>();
      
        System.out.println("WELCOME TO CONSOLE CHESS GAME");
        System.out.print("To start the game enter y or yes: ");
        String init = sc.nextLine();
        
        if(init.equalsIgnoreCase("Y") || init.equalsIgnoreCase("yes")) {
            while (!chessMatch.isCheckMate()) {
                try {
                    System.out.print(BoardColors.ANSI_RESET);
                    BoardView.clearScreen();
                    BoardView.printMatch(chessMatch, capturedChessPieces);
                    System.out.println();
                     System.out.print("Source position: ");
                    ChessPosition source = BoardView.readChessPosition(sc);

                    boolean[][] possibleMoves = chessMatch.possibleMoves(source);
                    BoardView.clearScreen();
                    BoardView.printBoard(chessMatch.getPieces(), possibleMoves);
                    System.out.println();
                    System.out.print("Target position: ");
                    ChessPosition target = BoardView.readChessPosition(sc);
                    
                    ChessPiece capturedPiece = chessMatch.performChessMove(source, target);
                    if(capturedPiece != null) {
                        capturedChessPieces.add(capturedPiece);
                    }
                    
                    if(chessMatch.getPromoted() != null) {
                        System.out.println("Enter the letter of the piece to promote to (Q/R/B/N):");
                        String type = sc.nextLine().toUpperCase();
                        chessMatch.replacepromotedPiece(type);
                    }
                }
                catch (ChessException | InputMismatchException e) {
                    System.out.println(e.getMessage());
                    sc.nextLine();
                }
            }

            BoardView.clearScreen();
            BoardView.printMatch(chessMatch, capturedChessPieces);
        }
    }
}