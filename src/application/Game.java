package application;

import chess.ChessMatch;
import chess.ChessPiece;
import chess.ChessPosition;

import java.util.Scanner;

public class Game {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ChessMatch match = new ChessMatch();

        while (true) {
            UI.printBoard(match.getPieces());
            System.out.println();
            System.out.print("Source: ");
            ChessPosition source = UI.readPosition(sc);

            System.out.println();
            System.out.print("Target: ");
            ChessPosition target = UI.readPosition(sc);

            ChessPiece capturedPiece = match.performChessMove(source, target);
        }
    }
}
