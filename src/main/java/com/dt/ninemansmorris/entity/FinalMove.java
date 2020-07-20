package com.dt.ninemansmorris.entity;

public class FinalMove {

	int pieceCoordinate;
	int detsinationCoordinate;
	int removedPieceCoordinate;

	public FinalMove(int pieceCoordinate, int detsinationCoordinate, int removedPieceCoordinate) {
		this.pieceCoordinate = pieceCoordinate;
		this.detsinationCoordinate = detsinationCoordinate;
		this.removedPieceCoordinate = removedPieceCoordinate;
	}

	public int getPieceCoordinate() {
		return pieceCoordinate;
	}

	public int getDetsinationCoordinate() {
		return detsinationCoordinate;
	}

	public int getRemovedPieceCoordinate() {
		return removedPieceCoordinate;
	}

	@Override
	public String toString() {
		return "FinalMove [pieceCoordinate=" + pieceCoordinate + ", detsinationCoordinate=" + detsinationCoordinate
				+ ", removedPieceCoordinate=" + removedPieceCoordinate + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + detsinationCoordinate;
		result = prime * result + pieceCoordinate;
		result = prime * result + removedPieceCoordinate;
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
		FinalMove other = (FinalMove) obj;
		if (detsinationCoordinate != other.detsinationCoordinate)
			return false;
		if (pieceCoordinate != other.pieceCoordinate)
			return false;
		if (removedPieceCoordinate != other.removedPieceCoordinate)
			return false;
		return true;
	}
}
