package chess;

import boardgame.Board;
import boardgame.Piece;
import boardgame.Position;

public abstract class ChessPiece extends Piece {

    private Color color;
    private int moveCount; // <--- NOVO: Contador de movimentos

    public ChessPiece(Board board, Color color) {
        super(board);
        this.color = color;
    }

    public Color getColor() {
        return color;
    }
    
    public int getMoveCount() {
        return moveCount;
    }
    
    // Método para incrementar o contador (usado ao mover)
    public void increaseMoveCount() {
        moveCount++;
    }

    // Método para decrementar (usado ao desfazer movimento)
    public void decreaseMoveCount() {
        moveCount--;
    }

    public ChessPosition getChessPosition() {
        return ChessPosition.fromPosition(position);
    }
    
    protected boolean isThereOpponentPiece(Position position) {
        ChessPiece p = (ChessPiece)getBoard().piece(position);
        return p != null && p.getColor() != color;
    }
}