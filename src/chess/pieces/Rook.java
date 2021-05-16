package chess.pieces;

import boardgame.Board;
import boardgame.Position;
import chess.ChessPiece;
import chess.Color;

public class Rook extends ChessPiece {

    public Rook(Board board, Color color) {
        super(board, color);
    }

    @Override
    public String toString() {
        return "R";
    }

    @Override
    public boolean[][] possibleMoves() {
        boolean[][] matrix = new boolean[getBoard().getRows()][getBoard().getColumns()];

        Position positionAux = new Position(0, 0);

        //left
        positionAux.setValues(position.getRow(), position.getColumn() - 1);

        while (getBoard().positionExistsByPosition(positionAux) && !getBoard().hasPiece(positionAux)) {
            matrix[positionAux.getRow()][positionAux.getColumn()] = true;
            positionAux.setColumn(positionAux.getColumn() - 1);
        }

        if (getBoard().positionExistsByPosition(positionAux) && isThereOpponentPiece(positionAux)) {
            matrix[positionAux.getRow()][positionAux.getColumn()] = true;
        }

        //right
        positionAux.setValues(position.getRow(), position.getColumn() + 1);

        while (getBoard().positionExistsByPosition(positionAux) && !getBoard().hasPiece(positionAux)) {
            matrix[positionAux.getRow()][positionAux.getColumn()] = true;
            positionAux.setColumn(positionAux.getColumn() + 1);
        }

        if (getBoard().positionExistsByPosition(positionAux) && isThereOpponentPiece(positionAux)) {
            matrix[positionAux.getRow()][positionAux.getColumn()] = true;
        }

        //above
        positionAux.setValues(position.getRow() - 1, position.getColumn());

        while (getBoard().positionExistsByPosition(positionAux) && !getBoard().hasPiece(positionAux)) {
            matrix[positionAux.getRow()][positionAux.getColumn()] = true;
            positionAux.setRow(positionAux.getRow() - 1);
        }

        if (getBoard().positionExistsByPosition(positionAux) && isThereOpponentPiece(positionAux)) {
            matrix[positionAux.getRow()][positionAux.getColumn()] = true;
        }

        //below
        positionAux.setValues(position.getRow() + 1, position.getColumn());

        while (getBoard().positionExistsByPosition(positionAux) && !getBoard().hasPiece(positionAux)) {
            matrix[positionAux.getRow()][positionAux.getColumn()] = true;
            positionAux.setRow(positionAux.getRow() + 1);
        }

        if (getBoard().positionExistsByPosition(positionAux) && isThereOpponentPiece(positionAux)) {
            matrix[positionAux.getRow()][positionAux.getColumn()] = true;
        }

        return matrix;
    }
}
