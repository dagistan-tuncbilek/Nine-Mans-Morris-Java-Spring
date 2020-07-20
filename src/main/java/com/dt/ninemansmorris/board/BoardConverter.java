package com.dt.ninemansmorris.board;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.dt.ninemansmorris.entity.Pieces;

public class BoardConverter {

	public List<Color> convert(Pieces pieces) {
		List<Color> piecesList = new ArrayList<Color>();
		
		for (int i = 0; i < 42; i++) {
			int point = pieces.getPieceArray()[i];
			switch (point) {
			case 0:
				piecesList.add(Color.WHITE);
				break;
			case 1:
				piecesList.add(Color.BLACK);
				break;
			case 2:
				piecesList.add(Color.EMPTY);
				break;
			default:
				System.out.println("Pieces are not in correct format");
			}
		}
		// index of the list used as a coordinate of the board.
		return Collections.unmodifiableList(piecesList);
		 
	}
}
