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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + destinationCoordinate;
		result = prime * result + ((piece == null) ? 0 : piece.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Move other = (Move) obj;
		if (destinationCoordinate != other.destinationCoordinate)
			return false;
		if (piece == null) {
			if (other.piece != null)
				return false;
		} else if (!piece.equals(other.piece))
			return false;
		return true;
	}

}
