package application;

import boardgame.ChessException;
import chess.ChessMatch;
import chess.ChessPiece;
import chess.ChessPosition;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Game {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ChessMatch match = new ChessMatch();

        while (true) {
            try {
                UI.clearScreen();

                UI.printMatch(match);

                System.out.println();
                System.out.print("Source: ");
                ChessPosition source = UI.readPosition(sc);

                UI.clearScreen();
                UI.printBoard(match.getPieces(),  match.possibleMoves(source));

                System.out.println();
                System.out.print("Target: ");
                ChessPosition target = UI.readPosition(sc);

                ChessPiece capturedPiece = match.performChessMove(source, target);
            } catch (ChessException | InputMismatchException e) {
                System.out.println(e.getMessage());
                sc.nextLine();
            }
        }
    }
}
