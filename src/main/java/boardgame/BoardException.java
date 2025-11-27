package boardgame;

// RuntimeException é uma exceção que não te obriga a tratar (try-catch) o tempo todo
public class BoardException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    public BoardException(String msg) {
        super(msg);
    }
}