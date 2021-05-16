package chess;

import boardgame.Board;
import boardgame.ChessException;
import boardgame.Piece;
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

    public ChessPiece performChessMove(ChessPosition sourcePosition, ChessPosition targetPosition) {
        Position source = sourcePosition.toPosition();
        Position target = targetPosition.toPosition();

        validateSourcePosition(source);
        validateTargetPosition(source, target);

        Piece capturedPiece = makeMove(source, target);

        return (ChessPiece) capturedPiece;
    }

    public boolean[][] possibleMoves(ChessPosition sourcePosition) {
        Position position = sourcePosition.toPosition();

        validateSourcePosition(position);

        return board.piece(position).possibleMoves();
    }

    private Piece makeMove(Position source, Position target) {
        Piece piece = board.removePiece(source);
        Piece capturedPiece = board.removePiece(target);
        board.placePiece(piece, target);
        return  capturedPiece;
    }

    private void validateSourcePosition(Position position) {
        if (!board.hasPiece(position)) {
            throw new ChessException("Error chess position: There is no piece on source position");
        }

        if (!board.piece(position).isThereAnyPossibleMove()) {
            throw new ChessException("Error chess position: There is no possible moves for the chosen piece");
        }
    }

    private void validateTargetPosition(Position source, Position target) {
        if (!board.piece(source).canMove(target)) {
            throw new ChessException("Error target position: The chosen piece can't move to target position");
        }
    }
}
