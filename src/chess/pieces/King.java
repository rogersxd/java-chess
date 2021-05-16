package chess.pieces;

import boardgame.Board;
import boardgame.Position;
import chess.ChessPiece;
import chess.Color;

public class King extends ChessPiece {

    public King(Board board, Color color) {
        super(board, color);
    }

    @Override
    public String toString() {
        return "K";
    }

    @Override
    public boolean[][] possibleMoves() {
        boolean[][] matrix = new boolean[getBoard().getRows()][getBoard().getColumns()];

        Position positionAux = new Position(0, 0);

        getAboveMoves(matrix, positionAux);
        getBelowMoves(matrix, positionAux);
        getLeftMoves(matrix, positionAux);
        getRightMoves(matrix, positionAux);

        return matrix;
    }

    private boolean[][] getAboveMoves(boolean[][] matrix, Position positionAux) {
        positionAux.setValues(position.getRow() - 1, position.getColumn());

        if (getBoard().positionExistsByPosition(positionAux) && hasAvailableMovement(positionAux)) {
            matrix[positionAux.getRow()][positionAux.getColumn()] = true;
        }

        positionAux.setValues(position.getRow() - 1, position.getColumn() + 1);

        if (getBoard().positionExistsByPosition(positionAux) && hasAvailableMovement(positionAux)) {
            matrix[positionAux.getRow()][positionAux.getColumn()] = true;
        }

        positionAux.setValues(position.getRow() - 1, position.getColumn() - 1);

        if (getBoard().positionExistsByPosition(positionAux) && hasAvailableMovement(positionAux)) {
            matrix[positionAux.getRow()][positionAux.getColumn()] = true;
        }

        return matrix;
    }

    private boolean[][] getBelowMoves(boolean[][] matrix, Position positionAux) {
        positionAux.setValues(position.getRow() + 1, position.getColumn());

        if (getBoard().positionExistsByPosition(positionAux) && hasAvailableMovement(positionAux)) {
            matrix[positionAux.getRow()][positionAux.getColumn()] = true;
        }

        positionAux.setValues(position.getRow() + 1, position.getColumn() + 1);

        if (getBoard().positionExistsByPosition(positionAux) && hasAvailableMovement(positionAux)) {
            matrix[positionAux.getRow()][positionAux.getColumn()] = true;
        }

        positionAux.setValues(position.getRow() + 1, position.getColumn() - 1);

        if (getBoard().positionExistsByPosition(positionAux) && hasAvailableMovement(positionAux)) {
            matrix[positionAux.getRow()][positionAux.getColumn()] = true;
        }

        return matrix;
    }

    private boolean[][] getLeftMoves(boolean[][] matrix, Position positionAux) {
        positionAux.setValues(position.getRow(), position.getColumn() - 1);

        if (getBoard().positionExistsByPosition(positionAux) && hasAvailableMovement(positionAux)) {
            matrix[positionAux.getRow()][positionAux.getColumn()] = true;
        }

        return matrix;
    }

    private boolean[][] getRightMoves(boolean[][] matrix, Position positionAux) {
        positionAux.setValues(position.getRow(), position.getColumn() + 1);

        if (getBoard().positionExistsByPosition(positionAux) && hasAvailableMovement(positionAux)) {
            matrix[positionAux.getRow()][positionAux.getColumn()] = true;
        }

        return matrix;
    }

    private boolean hasAvailableMovement(Position position) {
        ChessPiece piece = (ChessPiece) getBoard().piece(position);

        return piece == null || piece.getColor() != getColor();
    }
}
