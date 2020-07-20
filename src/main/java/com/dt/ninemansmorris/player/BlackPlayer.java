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

public class BlackPlayer extends Player {
	
	public BlackPlayer(Board board, Color color, List<Piece> gameBoard) {
		super(board, color, gameBoard);
		setLegalMoves(calculateAllLegalMoves());
	}

	public List<Move> calculateAllLegalMoves() {
		List<Move> moveList = new ArrayList<Move>();
		int counter = 0;
		for (Piece piece : getGameBoard()) {
			if (piece.getPieceColor() == Color.BLACK) {
				moveList.addAll(piece.getLegalMoveList());
				counter++;
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
		pieceColorList.set(move.getDestinationCoordinate(), Color.BLACK);
		MoveTransition moveTransition;
		if (BoardUtils.controlMill(pieceColorList, move.getDestinationCoordinate())) {
			EasyDeleteStone easyDeleteStone = new EasyDeleteStone(pieceColorList, Color.WHITE);
			moveTransition = new MoveTransition (Collections.unmodifiableList(easyDeleteStone.getPieceList()), Color.WHITE);
		} else {
			moveTransition = new MoveTransition (Collections.unmodifiableList(pieceColorList), Color.WHITE);
		}
		return moveTransition;
	}

	@Override
	public String toString() {
		return " BlackPlayer ";
	}

	@Override
	public Player getOpponent() {
		return this.getBoard().whitePlayer();
	}
}