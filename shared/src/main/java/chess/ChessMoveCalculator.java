package chess;

import java.util.Collection;

public class ChessMoveCalculator {
    private ChessBoard board;
    private ChessPosition position;
    private ChessPiece piece;

    public ChessMoveCalculator(ChessBoard board, ChessPosition position) {
        this.board = board;
        this.position = position;
        this.piece = board.getPiece(position);
    }

    public Collection<ChessMove> calculateMove() {
        if (piece.getPieceType() == ChessPiece.PieceType.PAWN) {
            return movePawn();
        }
        else if (piece.getPieceType() == ChessPiece.PieceType.ROOK) {
            return moveRook();
        }
        else if (piece.getPieceType() == ChessPiece.PieceType.KNIGHT) {
            return moveKnight();
        }
        else if (piece.getPieceType() == ChessPiece.PieceType.BISHOP) {
            return moveBishop();
        }
        else if (piece.getPieceType() == ChessPiece.PieceType.KING) {
            return moveKing();
        }
        else if (piece.getPieceType() == ChessPiece.PieceType.QUEEN) {
            return moveQueen();
        }
        return null;
    }

    private Collection<ChessMove> movePawn() {
        return null;
    }
    private Collection<ChessMove> moveRook() {
        return null;
    }
    private Collection<ChessMove> moveKnight() {
        return null;
    }
    private Collection<ChessMove> moveBishop() {
        return null;
    }
    private Collection<ChessMove> moveKing() {
        return null;
    }
    private Collection<ChessMove> moveQueen() {
        return null;
    }

}
