package views;

import boardGame.*;
import pieces.*;
import Chess.*;
import java.util.*;
import java.util.stream.Collectors;

public class BoardView {

    public static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    public static ChessPosition readChessPosition(Scanner sc) {
        try {
            String s = sc.nextLine();
            char column = s.charAt(0);
            int row = Integer.parseInt(s.substring(1));
            return new ChessPosition(column, row);
        } catch (RuntimeException e) {
            throw new InputMismatchException("Error reading chess position. Valid values are from a1 to h8");
        }
    }

    public static void printMatch(ChessMatch chessMatch, List<ChessPiece> capturedPieces) {
        printBoard(chessMatch.getPieces());
        System.out.println();
        printCapturedPieces(capturedPieces);
        System.out.println("Turn: " + chessMatch.getTurn());
        if (!chessMatch.isCheckMate()) {
            System.out.println("Waiting for player: " + chessMatch.getCurrentPlayer());
            if (chessMatch.isCheck()) {
                System.out.println("CHECK!");
            }
        } else {
            System.out.println("CHECKMATE!");
            System.out.println("Winner: " + chessMatch.getCurrentPlayer());
        }
    }

    public static void printBoard(ChessPiece[][] pieces) {
        for (int i = 0; i < pieces.length; i++) {
            System.out.print((8 - i) + " ");
            for (int j = 0; j < pieces.length; j++) {
                printPiece(pieces[i][j], false);
            }
            System.out.println();
        }
        System.out.println("  a b c d e f g h");
    }

    public static void printBoard(ChessPiece[][] pieces, boolean[][] possibleMoves) {
        for (int i = 0; i < pieces.length; i++) {
            System.out.print((8 - i) + " ");
            for (int j = 0; j < pieces.length; j++) {
                printPiece(pieces[i][j], possibleMoves[i][j]);
            }
            System.out.println();
        }
        System.out.println("  a b c d e f g h");
    }

    private static void printPiece(ChessPiece piece, boolean background) {
        if (background) {
            System.out.print(BoardColors.ANSI_BLUE_BACKGROUND);
        }
        if (piece == null) {
            System.out.print("-" + BoardColors.ANSI_RESET);
        }
        else {
            if (piece.getColor() == Color.WHITE) {
                System.out.print(BoardColors.ANSI_WHITE + piece + BoardColors.ANSI_RESET);
            }
            else {
                System.out.print(BoardColors.ANSI_YELLOW + piece + BoardColors.ANSI_RESET);
            }
        }
        System.out.print(" ");
    }

    private static void printCapturedPieces(List<ChessPiece> capturedPieces) {
        List<ChessPiece> white = capturedPieces.stream()
                .filter(x -> x.getColor() == Color.WHITE)
                .collect(Collectors.toList());
        List<ChessPiece> black = capturedPieces.stream()
                .filter(x -> x.getColor() == Color.BLACK)
                .collect(Collectors.toList());
        
        System.out.println("Captured pieces:");
        System.out.print("White pieces: ");
        System.out.print(BoardColors.ANSI_WHITE);
        System.out.println(Arrays.toString(white.toArray()));
        System.out.print(BoardColors.ANSI_RESET);
        System.out.print("Black pieces: ");
        System.out.print(BoardColors.ANSI_YELLOW);
        System.out.println(Arrays.toString(black.toArray()));
        System.out.print(BoardColors.ANSI_RESET);
    }
}