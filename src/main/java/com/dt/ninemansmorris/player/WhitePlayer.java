package com.dt.ninemansmorris.player;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.dt.ninemansmorris.board.Board;
import com.dt.ninemansmorris.board.Color;
import com.dt.ninemansmorris.engine.BoardUtils;
import com.dt.ninemansmorris.engine.EasyDeleteStone;
import com.dt.ninemansmorris.engine.MoveTransition;
import com.dt.ninemansmorris.move.Move;
import com.dt.ninemansmorris.piece.Piece;

public class WhitePlayer extends Player {
	
	public WhitePlayer(Board board, Color color, List<Piece> gameBoard) {
		super(board, color, gameBoard);
		setLegalMoves(calculateAllLegalMoves());
	}
	
	@Override
	public List<Move> calculateAllLegalMoves() {
		List<Move> moveList = new ArrayList<Move>();
		int counter = 0;
		boolean flag = false;
		for (Piece piece : getGameBoard()) {
			if (piece.getPieceColor() == Color.WHITE) {
				counter++;
				if (piece.getPiecePosition()<24) {
					moveList.addAll(piece.getLegalMoveList());
				} else {
					if (!flag) {
					moveList.addAll(piece.getLegalMoveList());
					flag = true;
					}
				}
			}
		}
		setPieceCount(counter);
		return Collections.unmodifiableList(moveList);
	}

	@Override
	public MoveTransition makeMove(Move move) {
		List<Color> pieceColorList = new ArrayList<Color>();
		pieceColorList.addAll(getBoard().getPieceColorList());
		pieceColorList.set(move.getCurrentCoordinate(), Color.EMPTY);
		pieceColorList.set(move.getDestinationCoordinate(), Color.WHITE);
		MoveTransition moveTransition;
		if (BoardUtils.controlMill(pieceColorList, move.getDestinationCoordinate())) {
			EasyDeleteStone easyDeleteStone = new EasyDeleteStone(pieceColorList, Color.BLACK);
			moveTransition = new MoveTransition (Collections.unmodifiableList(easyDeleteStone.getPieceList()), Color.BLACK);
		} else {
			moveTransition = new MoveTransition (Collections.unmodifiableList(pieceColorList), Color.BLACK);
		}
		return moveTransition;
	}

	@Override
	public String toString() {
		return " WhitePlayer ";
	}

	@Override
	public Player getOpponent() {
		return this.getBoard().blackPlayer();
	}
}
