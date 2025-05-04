package boardGame;

public abstract class Piece implements GameEntity {
    protected Position position;
    private Board board;

    public Piece(Board board) {
        this.board = board;
        position = null;
    }

    protected Board getBoard() {
        return board;
    }

    public abstract boolean[][] possibleMoves();

    public boolean possibleMove(Position position) {
        return possibleMoves()[position.getRow()][position.getColumn()];
    }

    public boolean isThereAnyPossibleMove() {
        boolean[][] mat = possibleMoves();
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[i].length; j++) {  // Fixed column bound
                if (mat[i][j]) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public void displayInfo() {
        System.out.println(this.getClass().getSimpleName() + " at position: " + position);
    }
}

