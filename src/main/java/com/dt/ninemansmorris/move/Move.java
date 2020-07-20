package com.dt.ninemansmorris.move;

import com.dt.ninemansmorris.board.Board;
import com.dt.ninemansmorris.piece.Piece;

public class Move {

	protected final Piece piece;
	protected final int destinationCoordinate;

	public Move(Piece piece, int destinationCoordinate) {
		this.piece = piece;
		this.destinationCoordinate = destinationCoordinate;
	}

	public Board execute() {
		// TODO Auto-generated method stub
		return null;
	}


	public int getCurrentCoordinate() {
		return getPiece().getPiecePosition();
	}

	public Piece getPiece() {
		return piece;
	}

	public int getDestinationCoordinate() {
		return destinationCoordinate;
	}

	@Override
	public String toString() {
		return "Move [Current Coorinate = " + piece.getPiecePosition() + ", destinationCoordinate = " + destinationCoordinate + "]";
	}

}
