package boardgame;

public class Board {
    private int rows;
    private int columns;
    private Piece[][] pieces;

    public Board(int rows, int columns) {
        if (rows < 8 && columns < 8) {
            throw new BoardException("Error creating board: Required 8 rows and 8 columns");
        }

        this.rows = rows;
        this.columns = columns;

        pieces = new Piece[rows][columns];
    }

    public int getRows() {
        return rows;
    }

    public int getColumns() {
        return columns;
    }

    public Piece piece(int row, int column) {
        if (!positionExists(row, column)) {
            throw new BoardException("Error position board: Position not exists");
        }

        return pieces[row][column];
    }

    public Piece piece(Position position) {
        return pieces[position.getRow()][position.getColumn()];
    }

    public void placePiece(Piece piece, Position position) {
        if (hasPiece(position)) {
            throw new BoardException("Error position board: There is a piece in position");
        }

        pieces[position.getRow()][position.getColumn()] = piece;
        piece.position = position;
    }

    public boolean positionExistsByPosition(Position position) {
        return positionExists(position.getRow(), position.getColumn());
    }

    private boolean positionExists(int row, int column) {
        return row >= 0 && row <= 8 && column >= 0 && column <= 8;
    }

    public boolean hasPiece(Position position) {
        if (!positionExistsByPosition(position)) {
            throw new BoardException("Error position board: Position not exists");
        }

        return piece(position) != null;
    }

    public Piece removePiece(Position position) {
        if (!positionExistsByPosition(position)) {
            throw new BoardException("Error position board: Position not exists");
        }

        if (piece(position) == null) {
            return null;
        }

        Piece pieceAux = piece(position);
        pieceAux.position = null;
        pieces[position.getRow()][position.getColumn()] = null;

        return pieceAux;
    }
}
