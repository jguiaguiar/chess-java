package boardgame;

public abstract class Piece { // <--- 1. Agora a classe é abstrata

    protected Position position;
    private Board board;

    public Piece(Board board) {
        this.board = board;
        this.position = null;
    }

    protected Board getBoard() {
        return board;
    }

    // 2. Método abstrato: cada peça (Rei, Torre) terá que implementar sua própria lógica
    public abstract boolean[][] possibleMoves();

    // 3. Hook methods: métodos prontos que usam o método abstrato acima
    
    // Verifica se pode mover para uma posição específica
    public boolean possibleMove(Position position) {
        return possibleMoves()[position.getRow()][position.getColumn()];
    }

    // Verifica se existe pelo menos um movimento possível para a peça (para saber se está travada)
    public boolean isThereAnyPossibleMove() {
        boolean[][] mat = possibleMoves();
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                if (mat[i][j]) {
                    return true;
                }
            }
        }
        return false;
    }
}