package com.dt.ninemansmorris.piece;

import java.util.List;

import com.dt.ninemansmorris.board.Color;
import com.dt.ninemansmorris.move.Move;


public abstract class Piece {
	
	private final int piecePosition;
	private final Color pieceColor;
	private final List<Move> legalMoveList; 
	
	public Piece(List<Color> pieceColorList, int piecePosition, Color color) {
		this.piecePosition = piecePosition;
		this.pieceColor = color;
		this.legalMoveList = calculateLegalMoves(pieceColorList);
	}

	public abstract List<Move> calculateLegalMoves(List<Color> pieceColorList);
	
	public int[] getCandidateCoordinates() {
		return new int[] {0,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23};
	}
	
	public int[] getCandidateCoordinates(int piecePosition) {
		switch (piecePosition) {
		case 0: return new int[] {1,9}; 
		case 1: return new int[] {0,2,4}; 
		case 2: return new int[] {1,14}; 		
		case 3: return new int[] {4,10}; 
		case 4: return new int[] {1,3,5,7}; 		
		case 5: return new int[] {4,13}; 
		case 6: return new int[] {7,11}; 		
		case 7: return new int[] {4,6,8}; 
		case 8: return new int[] {7,12}; 		
		case 9: return new int[] {0,10,21}; 
		case 10: return new int[] {3,9,11,18}; 
		case 11: return new int[] {6,10,15}; 
		case 12: return new int[] {8,13,17}; 	
		case 13: return new int[] {5,12,14,20}; 
		case 14: return new int[] {2,13,23}; 		
		case 15: return new int[] {11,16}; 
		case 16: return new int[] {15,17,19}; 
		case 17: return new int[] {12,16}; 		
		case 18: return new int[] {10,19}; 
		case 19: return new int[] {16,18,20,22}; 
		case 20: return new int[] {13,19}; 
		case 21: return new int[] {9,22}; 
		case 22: return new int[] {19,21,23}; 
		case 23: return new int[] {14,22}; 
		default: throw new RuntimeException("Not a legal move coordinate");
		}
	}
	
	public int getPiecePosition() {
		return piecePosition;
	}

	public Color getPieceColor() {
		return pieceColor;
	}

	public List<Move> getLegalMoveList() {
		return legalMoveList;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((legalMoveList == null) ? 0 : legalMoveList.hashCode());
		result = prime * result + ((pieceColor == null) ? 0 : pieceColor.hashCode());
		result = prime * result + piecePosition;
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
		Piece other = (Piece) obj;
		if (legalMoveList == null) {
			if (other.legalMoveList != null)
				return false;
		} else if (!legalMoveList.equals(other.legalMoveList))
			return false;
		if (pieceColor != other.pieceColor)
			return false;
		if (piecePosition != other.piecePosition)
			return false;
		return true;
	}
}
