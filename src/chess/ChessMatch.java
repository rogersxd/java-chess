package chess;

import boardgame.Board;
import boardgame.Position;
import chess.pieces.King;
import chess.pieces.Rook;

public class ChessMatch {
    private Board board;

    public ChessMatch() {
        board = new Board(8, 8);
        initSetup();
    }

    public ChessPiece[][] getPieces() {
        ChessPiece[][] chessPieces = new ChessPiece[board.getRows()][board.getColumns()];

        for (int i = 0; i < board.getRows(); i++) {
            for (int j = 0; j < board.getColumns(); j++) {
                chessPieces[i][j] = (ChessPiece) board.piece(i, j);
            }
        }

        return chessPieces;
    }

    private void initSetup() {
        setBlackPieces();
        setWhitePieces();
    }

    private void setBlackPieces() {
        board.placePiece(new Rook(board, Color.BLACK), new ChessPosition('a',8).toPosition());
        board.placePiece(new Rook(board, Color.BLACK), new ChessPosition('h',8).toPosition());
        board.placePiece(new King(board, Color.BLACK), new ChessPosition('e',8).toPosition());
    }

    private void setWhitePieces() {
        board.placePiece(new Rook(board, Color.WHITE), new ChessPosition('a',1).toPosition());
        board.placePiece(new Rook(board, Color.WHITE), new ChessPosition('h',1).toPosition());
        board.placePiece(new King(board, Color.WHITE), new ChessPosition('e',1).toPosition());
    }
}
