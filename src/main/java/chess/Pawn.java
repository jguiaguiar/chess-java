package chess;

import boardgame.Board;
import boardgame.Position;

public class Pawn extends ChessPiece {

    public Pawn(Board board, Color color) {
        super(board, color);
    }

    @Override
    public boolean[][] possibleMoves() {
        boolean[][] mat = new boolean[getBoard().getRows()][getBoard().getColumns()];
        
        Position p = new Position(0, 0);

        if (getColor() == Color.WHITE) {
            // Movimento normal (1 casa acima)
            p.setValues(position.getRow() - 1, position.getColumn());
            if (getBoard().positionExists(p) && !getBoard().thereIsAPiece(p)) {
                mat[p.getRow()][p.getColumn()] = true;
            }
            // Movimento inicial (2 casas acima)
            Position p2 = new Position(position.getRow() - 2, position.getColumn());
            if (getBoard().positionExists(p) && !getBoard().thereIsAPiece(p) && 
                getBoard().positionExists(p2) && !getBoard().thereIsAPiece(p2) && 
                getMoveCount() == 0) {
                mat[p2.getRow()][p2.getColumn()] = true;
            }
            // Captura diagonal esquerda
            p.setValues(position.getRow() - 1, position.getColumn() - 1);
            if (getBoard().positionExists(p) && isThereOpponentPiece(p)) {
                mat[p.getRow()][p.getColumn()] = true;
            }
            // Captura diagonal direita
            p.setValues(position.getRow() - 1, position.getColumn() + 1);
            if (getBoard().positionExists(p) && isThereOpponentPiece(p)) {
                mat[p.getRow()][p.getColumn()] = true;
            }
        }
        else {
            // Lógica para as PEÇAS PRETAS (inverso)
            
            // Movimento normal (1 casa abaixo)
            p.setValues(position.getRow() + 1, position.getColumn());
            if (getBoard().positionExists(p) && !getBoard().thereIsAPiece(p)) {
                mat[p.getRow()][p.getColumn()] = true;
            }
            // Movimento inicial (2 casas abaixo)
            Position p2 = new Position(position.getRow() + 2, position.getColumn());
            if (getBoard().positionExists(p) && !getBoard().thereIsAPiece(p) && 
                getBoard().positionExists(p2) && !getBoard().thereIsAPiece(p2) && 
                getMoveCount() == 0) {
                mat[p2.getRow()][p2.getColumn()] = true;
            }
            // Captura diagonal esquerda
            p.setValues(position.getRow() + 1, position.getColumn() - 1);
            if (getBoard().positionExists(p) && isThereOpponentPiece(p)) {
                mat[p.getRow()][p.getColumn()] = true;
            }
            // Captura diagonal direita
            p.setValues(position.getRow() + 1, position.getColumn() + 1);
            if (getBoard().positionExists(p) && isThereOpponentPiece(p)) {
                mat[p.getRow()][p.getColumn()] = true;
            }
        }
        return mat;
    }

    @Override
    public String toString() {
        return "P";
    }
}