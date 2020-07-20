package com.dt.ninemansmorris.engine;

import java.util.ArrayList;
import java.util.List;

import com.dt.ninemansmorris.board.Color;

public class EasyDeleteStone {
	
	List<Color> oldPieceList;
	Color colorForDelete;
	
	public EasyDeleteStone(List<Color> pieceColorList, Color color) {
		this.oldPieceList = pieceColorList;
		this.colorForDelete = color;
	}

	public List<Color> getPieceList() {
		List<Color> pieceColorList = new ArrayList<Color>();
		pieceColorList = oldPieceList;
		while (true) {
			int random =  (int)(Math.random()*24);
			if (pieceColorList.get(random) == colorForDelete) {
				pieceColorList.set(random, Color.EMPTY);
				break;
			}
		}
		return pieceColorList;
	}

}
