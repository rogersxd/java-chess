package application;

import chess.ChessMatch;

public class Game {
    public static void main(String[] args) {
        ChessMatch match = new ChessMatch();
        UI.printBoard(match.getPieces());
    }
}
