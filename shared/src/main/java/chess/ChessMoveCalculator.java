package chess;

import java.util.Collection;
import java.util.*;

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

    private boolean checkSquare(Collection<ChessMove> returnMoves, ChessPosition incrementingPosition) {
        if (board.getPiece(incrementingPosition) == null) {
            returnMoves.add(new ChessMove(position,incrementingPosition,null));
            return false;
        }
        if ((board.getPiece(incrementingPosition) != null)){
            if (board.getPiece(incrementingPosition).getTeamColor() != piece.getTeamColor()) {
                returnMoves.add(new ChessMove(position,incrementingPosition,null));
            }
            return true;
        }
        return true;
    }

    private Collection<ChessMove> movePawn() {
        return null;
    }
    private Collection<ChessMove> moveRook() {
        List<ChessMove> returnMoves = new ArrayList<>();
        int i = 1;
        boolean pieceBlocking = false;
        while (position.getRow() + i <= 8 && !pieceBlocking) {
            ChessPosition incrementingPosition = new ChessPosition(position.getRow() + i, position.getColumn());
            pieceBlocking = checkSquare(returnMoves, incrementingPosition);
            i++;
        }
        i = 1;
        pieceBlocking = false;
        while (position.getRow() - i >= 1 && !pieceBlocking) {
            ChessPosition incrementingPosition = new ChessPosition(position.getRow() - i, position.getColumn());
            pieceBlocking = checkSquare(returnMoves, incrementingPosition);
            i--;
        }
        i = 1;
        pieceBlocking = false;
        while (position.getColumn() + i <= 8 && !pieceBlocking) {
            ChessPosition incrementingPosition = new ChessPosition(position.getRow(), position.getColumn() + i);
            pieceBlocking = checkSquare(returnMoves, incrementingPosition);
            i++;
        }
        i = 1;
        pieceBlocking = false;
        while (position.getColumn() - i >= 1 && !pieceBlocking) {
            ChessPosition incrementingPosition = new ChessPosition(position.getRow(), position.getColumn() - i);
            pieceBlocking = checkSquare(returnMoves, incrementingPosition);
            i++;
        }
        return returnMoves;
    }

    private Collection<ChessMove> moveKnight() {
        return null;
    }

    private Collection<ChessMove> moveBishop() {
        List<ChessMove> returnMoves = new ArrayList<>();
        int i = 1;
        boolean pieceBlocking = false;
        while (position.getRow() + i <= 8 && position.getColumn() + i <= 8 && !pieceBlocking) {
            ChessPosition incrementingPosition = new ChessPosition(position.getRow() + i, position.getColumn() + i);
            pieceBlocking = checkSquare(returnMoves, incrementingPosition);
            i++;
        }
        i = 1;
        pieceBlocking = false;
        while (position.getRow() - i >= 1 && position.getColumn() + i <= 8 && !pieceBlocking) {
            ChessPosition incrementingPosition = new ChessPosition(position.getRow() - i, position.getColumn() + i);
            pieceBlocking = checkSquare(returnMoves, incrementingPosition);
            i--;
        }
        i = 1;
        pieceBlocking = false;
        while (position.getRow() + i <= 8 && position.getColumn() - i >= 1 && !pieceBlocking) {
            ChessPosition incrementingPosition = new ChessPosition(position.getRow() + i, position.getColumn() - i);
            pieceBlocking = checkSquare(returnMoves, incrementingPosition);
            i++;
        }
        i = 1;
        pieceBlocking = false;
        while (position.getRow() - i >= 1 && position.getColumn() - i >= 1 && !pieceBlocking) {
            ChessPosition incrementingPosition = new ChessPosition(position.getRow() - i, position.getColumn() - i);
            pieceBlocking = checkSquare(returnMoves, incrementingPosition);
            i++;
        }
        return returnMoves;
    }

    private Collection<ChessMove> moveKing() {
        List<ChessMove> returnMoves = new ArrayList<>();
        boolean redundant = false;
        if (position.getRow() + 1 <= 8) {
            ChessPosition oneOfEight = new ChessPosition(position.getRow() + 1, position.getColumn());
            redundant = checkSquare(returnMoves,oneOfEight);
        }
        if (position.getRow() + 1 <= 8 && position.getColumn() + 1 <= 8) {
            ChessPosition twoOfEight = new ChessPosition(position.getRow() + 1, position.getColumn() + 1);
            redundant = checkSquare(returnMoves,twoOfEight);
        }
        if (position.getColumn() + 1 <= 8) {
            ChessPosition threeOfEight = new ChessPosition(position.getRow(), position.getColumn() + 1);
            redundant = checkSquare(returnMoves,threeOfEight);
        }
        if (position.getRow() - 1 >= 1 && position.getColumn() + 1 <= 8) {
            ChessPosition fourOfEight = new ChessPosition(position.getRow() - 1, position.getColumn() + 1);
            redundant = checkSquare(returnMoves,fourOfEight);
        }
        if (position.getRow() - 1 >= 1) {
            ChessPosition fiveOfEight = new ChessPosition(position.getRow() - 1, position.getColumn());
            redundant = checkSquare(returnMoves,fiveOfEight);
        }
        if (position.getRow() - 1 >= 1 && position.getColumn() - 1 >= 1) {
            ChessPosition sixOfEight = new ChessPosition(position.getRow() - 1, position.getColumn() - 1);
            redundant = checkSquare(returnMoves,sixOfEight);
        }
        if (position.getColumn() - 1 >= 1) {
            ChessPosition sevenOfEight = new ChessPosition(position.getRow(), position.getColumn() - 1);
            redundant = checkSquare(returnMoves,sevenOfEight);
        }
        if (position.getRow() + 1 <= 8 && position.getColumn() - 1 >= 1) {
            ChessPosition eightOfEight = new ChessPosition(position.getRow() + 1, position.getColumn() - 1);
            redundant = checkSquare(returnMoves,eightOfEight);
        }
        return returnMoves;
    }

    private Collection<ChessMove> moveQueen() {
        Collection<ChessMove> returnMoves = moveRook();
        returnMoves.addAll(moveBishop());
        return returnMoves;
    }

}
