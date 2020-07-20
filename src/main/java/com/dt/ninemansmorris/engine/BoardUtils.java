package com.dt.ninemansmorris.engine;

import java.util.List;

import com.dt.ninemansmorris.board.Color;

public class BoardUtils {

	public static boolean controlMill(List<Color> pieceColorList, int stoneCoorinate) {
		switch (stoneCoorinate) {
		case 0:
			if (checkRow(pieceColorList, 0, 1, 2))
				return true;
			if (checkRow(pieceColorList, 0, 9, 21))
				return true;
			break;
		case 1:
			if (checkRow(pieceColorList, 0, 1, 2))
				return true;
			if (checkRow(pieceColorList, 1, 4, 7))
				return true;
			break;
		case 2:
			if (checkRow(pieceColorList, 0, 1, 2))
				return true;
			if (checkRow(pieceColorList, 2, 14, 23))
				return true;
			break;
		case 3:
			if (checkRow(pieceColorList, 3, 4, 5))
				return true;
			if (checkRow(pieceColorList, 3, 10, 18))
				return true;
			break;
		case 4:
			if (checkRow(pieceColorList, 3, 4, 5))
				return true;
			if (checkRow(pieceColorList, 4, 1, 7))
				return true;
			break;
		case 5:
			if (checkRow(pieceColorList, 3, 4, 5))
				return true;
			if (checkRow(pieceColorList, 5, 13, 20))
				return true;
			break;
		case 6:
			if (checkRow(pieceColorList, 6, 7, 8))
				return true;
			if (checkRow(pieceColorList, 6, 11, 15))
				return true;
			break;
		case 7:
			if (checkRow(pieceColorList, 6, 7, 8))
				return true;
			if (checkRow(pieceColorList, 7, 4, 1))
				return true;
			break;
		case 8:
			if (checkRow(pieceColorList, 6, 7, 8))
				return true;
			if (checkRow(pieceColorList, 8, 12, 17))
				return true;
			break;
		case 9:
			if (checkRow(pieceColorList, 9, 0, 21))
				return true;
			if (checkRow(pieceColorList, 9, 10, 11))
				return true;
			break;
		case 10:
			if (checkRow(pieceColorList, 10, 3, 18))
				return true;
			if (checkRow(pieceColorList, 9, 10, 11))
				return true;
			break;
		case 11:
			if (checkRow(pieceColorList, 11, 6, 15))
				return true;
			if (checkRow(pieceColorList, 9, 10, 11))
				return true;
			break;
		case 12:
			if (checkRow(pieceColorList, 12, 13, 14))
				return true;
			if (checkRow(pieceColorList, 12, 8, 17))
				return true;
			break;
		case 13:
			if (checkRow(pieceColorList, 12, 13, 14))
				return true;
			if (checkRow(pieceColorList, 13, 5, 20))
				return true;
			break;
		case 14:
			if (checkRow(pieceColorList, 12, 13, 14))
				return true;
			if (checkRow(pieceColorList, 14, 2, 23))
				return true;
			break;
		case 15:
			if (checkRow(pieceColorList, 15, 16, 17))
				return true;
			if (checkRow(pieceColorList, 15, 11, 6))
				return true;
			break;
		case 16:
			if (checkRow(pieceColorList, 15, 16, 17))
				return true;
			if (checkRow(pieceColorList, 16, 19, 22))
				return true;
			break;
		case 17:
			if (checkRow(pieceColorList, 15, 16, 17))
				return true;
			if (checkRow(pieceColorList, 17, 12, 8))
				return true;
			break;
		case 18:
			if (checkRow(pieceColorList, 18, 19, 20))
				return true;
			if (checkRow(pieceColorList, 18, 10, 3))
				return true;
			break;
		case 19:
			if (checkRow(pieceColorList, 18, 19, 20))
				return true;
			if (checkRow(pieceColorList, 19, 16, 22))
				return true;
			break;
		case 20:
			if (checkRow(pieceColorList, 18, 19, 20))
				return true;
			if (checkRow(pieceColorList, 20, 13, 5))
				return true;
			break;
		case 21:
			if (checkRow(pieceColorList, 21, 22, 23))
				return true;
			if (checkRow(pieceColorList, 21, 9, 0))
				return true;
			break;
		case 22:
			if (checkRow(pieceColorList, 21, 22, 23))
				return true;
			if (checkRow(pieceColorList, 22, 19, 16))
				return true;
			break;
		case 23:
			if (checkRow(pieceColorList, 21, 22, 23))
				return true;
			if (checkRow(pieceColorList, 23, 14, 2))
				return true;
			break;

		default:
			break;
		}
		return false;
	}

	public static boolean checkRow(List<Color> pieceColorList, int i, int j, int k) {
		Color color = pieceColorList.get(i);
		if (pieceColorList.get(j) == color && pieceColorList.get(k) == color) {
			return true;
		}
		return false;
	}
}
