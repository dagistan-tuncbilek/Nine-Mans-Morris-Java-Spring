package com.dt.ninemansmorris.entity;

import javax.persistence.Entity;

@Entity
public class Pieces {

	private int[] pieceArray;

	public Pieces() {		
	}

	public int[] getPieceArray() {
		return pieceArray;
	}

	public void setPieceArray(int[] pieceArray) {
		this.pieceArray = pieceArray;
	}

	public void setPieces() {
		
	}

}
