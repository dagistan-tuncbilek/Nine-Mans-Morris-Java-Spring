package com.dt.ninemansmorris.piece;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.dt.ninemansmorris.board.Color;
import com.dt.ninemansmorris.move.Move;


class PieceTest {
	
	List<Color> pieceColorList;
	Piece stone;
	Piece flyingStone;
	
	@BeforeEach
	void createColorList() {
		Color[] colorArray = {Color.WHITE, Color.EMPTY, Color.BLACK, Color.EMPTY, Color.EMPTY, Color.EMPTY,
				Color.EMPTY, Color.EMPTY, Color.WHITE, Color.EMPTY, Color.EMPTY, Color.EMPTY, Color.WHITE, Color.EMPTY,
				Color.EMPTY, Color.EMPTY, Color.EMPTY, Color.EMPTY, Color.EMPTY, Color.EMPTY, Color.EMPTY, Color.EMPTY,
				Color.EMPTY, Color.EMPTY, Color.EMPTY,  Color.BLACK, Color.BLACK, Color.BLACK, Color.BLACK,
				Color.BLACK, Color.BLACK, Color.BLACK, Color.BLACK, Color.WHITE, Color.WHITE, Color.WHITE, Color.WHITE,
				Color.WHITE, Color.EMPTY, Color.EMPTY, Color.EMPTY, Color.EMPTY};
		pieceColorList = Arrays.asList(colorArray);
		stone = new Stone(pieceColorList, 0, Color.WHITE);
		flyingStone = new FlyingStone(pieceColorList, 2, Color.BLACK);
	}
	
	@Test
	void stone() {
		Move move1 = new Move(stone, 1);
		Move move2 = new Move(stone, 9);
		final List<Move> moveList = Collections.unmodifiableList(Arrays.asList(move1, move2));
		assertEquals(moveList, stone.calculateLegalMoves(pieceColorList));
	}
	
	@Test
	void getCandidateCoordinates() {	
		assertAll(
				()-> assertArrayEquals(new int[] {19,21,23}, stone.getCandidateCoordinates(22), "stone fails"),
				()-> assertArrayEquals(new int[] {0,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23}, flyingStone.getCandidateCoordinates(), "flyingStone fails")
				);
	}

	private Object assertArraysEquals(String string, String string2, String string3) {
		// TODO Auto-generated method stub
		return null;
	}

}
