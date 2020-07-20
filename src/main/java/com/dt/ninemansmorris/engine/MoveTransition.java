package com.dt.ninemansmorris.engine;

import java.util.List;

import com.dt.ninemansmorris.board.Board;
import com.dt.ninemansmorris.board.Color;
import com.dt.ninemansmorris.move.MoveStatus;

public class MoveTransition {
	
	Board board;
	List<Color> pieceColorList;
	Color currentPlayerColor;
	MoveStatus moveStatus;
	
	public MoveTransition(List<Color> pieceColorList, Color playerColor) {
		this.pieceColorList = pieceColorList;
		this.currentPlayerColor = playerColor;
		this.moveStatus = setMoveStatus();
		this.board = new Board(pieceColorList, playerColor);	
	}

	private MoveStatus setMoveStatus() {
		int counter = 0;
		for (Color color : this.pieceColorList) {
			if (color == currentPlayerColor) {
				counter++;
				if (counter > 2) {
					return MoveStatus.DONE;
				}
			}
		}
		return MoveStatus.GAMEOVER;
	}

	public Board getBoard() {
		return board;
	}

	public MoveStatus getMoveStatus() {
		return moveStatus;
	}

	public Color getCurrentPlayerColor() {
		return currentPlayerColor;
	}

	@Override
	public String toString() {
		return "MoveTransition [currentPlayerColor=" + currentPlayerColor + ", moveStatus=" + moveStatus + "]";
	}
}
