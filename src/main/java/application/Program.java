package application;

import java.util.ArrayList; // Import necessário
import java.util.InputMismatchException;
import java.util.List;      // Import necessário
import java.util.Scanner;

import chess.ChessException;
import chess.ChessMatch;
import chess.ChessPiece;
import chess.ChessPosition;
import chess.UI;

public class Program {

    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        ChessMatch chessMatch = new ChessMatch();
        List<ChessPiece> captured = new ArrayList<>(); // Lista local para passar para a UI
        
        while (true) {
            try {
                UI.clearScreen();
                // Passamos a lista de capturadas aqui
                UI.printMatch(chessMatch, captured);
                
                System.out.println();
                System.out.print("Source: ");
                ChessPosition source = UI.readChessPosition(sc);
                
                boolean[][] possibleMoves = chessMatch.possibleMoves(source);
                UI.clearScreen();
                UI.printBoard(chessMatch.getPieces(), possibleMoves);
                
                System.out.println();
                System.out.print("Target: ");
                ChessPosition target = UI.readChessPosition(sc);
                
                ChessPiece capturedPiece = chessMatch.performChessMove(source, target);
                
                // Se alguma peça foi capturada nessa jogada, adicionamos à lista local
                if (capturedPiece != null) {
                    captured.add(capturedPiece);
                }
            }
            catch (ChessException e) {
                System.out.println(e.getMessage());
                sc.nextLine();
            }
            catch (InputMismatchException e) {
                System.out.println(e.getMessage());
                sc.nextLine();
            }
        }
    }
}