package com.dt.ninemansmorris.conroller;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.dt.ninemansmorris.entity.FinalMove;
import com.dt.ninemansmorris.entity.Pieces;

class AppControllerTest {

	

	
	@Test
	void conroller() {
		int[] pieces1 = { 2, 2, 2, 0, 2, 0, 2, 2, 2, 2, 2, 2, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 1, 2, 1, 1, 1, 1, 1,
				1, 1, 2, 2, 0, 0, 0, 0, 0, 0, 0};
		Pieces pieces = new Pieces();
		pieces.setPieceArray(pieces1);
		AppController controller = new AppController();
		FinalMove finalMove = new FinalMove(24, 4, -1);
		assertEquals(finalMove, controller.blackMove(pieces));
	}

}
