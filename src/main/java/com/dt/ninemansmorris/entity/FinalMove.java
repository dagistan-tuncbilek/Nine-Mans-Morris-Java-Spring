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
}
