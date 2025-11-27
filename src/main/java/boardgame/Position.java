package boardgame;

public class Position {

    private int row;
    private int column;

    // Construtor: Obriga a passar linha e coluna ao criar uma posição
    public Position(int row, int column) {
        this.row = row;
        this.column = column;
    }

    // Getters e Setters: Permitem acessar e modificar os valores de forma segura
    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getColumn() {
        return column;
    }

    public void setColumn(int column) {
        this.column = column;
    }

    // toString: Transforma o objeto em texto para facilitar quando formos imprimir
    @Override
    public String toString() {
        return row + ", " + column;
    }

    public void setValues(int row, int column) {
        this.row = row;
        this.column = column;
    }
}