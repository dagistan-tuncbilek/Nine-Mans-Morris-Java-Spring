package com.dt.ninemansmorris.board;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.dt.ninemansmorris.entity.Pieces;

class BoardConverterTest {

	@Test
	@DisplayName("Pieces list converting to ColorList")
	void convert() {
		int[] pieces1 = { 2, 0, 2, 2, 2, 2, 2, 0, 2, 2, 2, 0, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 1, 1, 1, 1, 1, 1, 1,
				1, 1, 0, 0, 0, 0, 0, 2, 2, 2, 2 };
		Pieces pieces = new Pieces();
		pieces.setPieceArray(pieces1);
		BoardConverter boardConverter = new BoardConverter();
		List<Color> actual = boardConverter.convert(pieces);
		System.out.println(actual);
		List<Color> expected = Arrays.asList(Color.EMPTY, Color.WHITE, Color.EMPTY, Color.EMPTY, Color.EMPTY,
				Color.EMPTY, Color.EMPTY, Color.WHITE, Color.EMPTY, Color.EMPTY, Color.EMPTY, Color.WHITE, Color.EMPTY,
				Color.EMPTY, Color.EMPTY, Color.EMPTY, Color.EMPTY, Color.EMPTY, Color.EMPTY, Color.EMPTY, Color.EMPTY,
				Color.EMPTY, Color.EMPTY, Color.EMPTY, Color.BLACK, Color.BLACK, Color.BLACK, Color.BLACK, Color.BLACK,
				Color.BLACK, Color.BLACK, Color.BLACK, Color.BLACK, Color.WHITE, Color.WHITE, Color.WHITE, Color.WHITE,
				Color.WHITE, Color.EMPTY, Color.EMPTY, Color.EMPTY, Color.EMPTY);
		assertEquals(expected, actual);
	}

}
