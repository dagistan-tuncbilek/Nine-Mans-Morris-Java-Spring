package com.dt.ninemansmorris.piece;

import java.util.List;

import com.dt.ninemansmorris.board.Color;
import com.dt.ninemansmorris.move.Move;

public class EmptyTile extends Piece {

	public EmptyTile(int piecePosition) {
		super(null, piecePosition, Color.EMPTY);
	}

	@Override
	public List<Move> calculateLegalMoves(List<Color> pieceColorList) {
		return null;
	}

	@Override
	public int[] getCandidateCoordinates(int coordinate) {
		// TODO Auto-generated method stub
		return null;
	}

}
