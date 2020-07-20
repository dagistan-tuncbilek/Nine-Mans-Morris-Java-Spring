package com.dt.ninemansmorris.piece;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.dt.ninemansmorris.board.Color;
import com.dt.ninemansmorris.move.Move;

public class FlyingStone extends Piece {
		
	public FlyingStone(List<Color> pieceColorList, int piecePosition, Color color) {
		super(pieceColorList, piecePosition, color);
	}

	@Override
	public List<Move> calculateLegalMoves(List<Color> pieceColorList) {
		final List<Move> legalMovesList = new ArrayList<>();
		for (final int currentCandidateTile :getCandidateCoordinates()) {
			if (pieceColorList.get(currentCandidateTile) == Color.EMPTY) {
				legalMovesList.add(new Move(this, currentCandidateTile));
			}
		}
		return Collections.unmodifiableList(legalMovesList);
	}



}
