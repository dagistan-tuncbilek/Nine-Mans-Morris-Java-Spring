package com.dt.ninemansmorris.conroller;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.dt.ninemansmorris.board.Board;
import com.dt.ninemansmorris.board.BoardConverter;
import com.dt.ninemansmorris.board.Color;
import com.dt.ninemansmorris.engine.MiniMax;
import com.dt.ninemansmorris.entity.FinalMove;
import com.dt.ninemansmorris.entity.Pieces;

@CrossOrigin("http://localhost:4200")
@RestController
public class AppController {
	
	@GetMapping("/get")
	public String sayHello() {
		return "Hello Get";
	}

	@PostMapping("/whiteMove")
	public FinalMove whiteMove (@RequestBody Pieces pieces) {
		BoardConverter converter = new BoardConverter();
		List<Color> piecesList = converter.convert(pieces);
		Board board = new Board(piecesList, Color.WHITE);
		MiniMax minimax = new MiniMax(5);
		FinalMove finalMove = minimax.execute(board);
		System.out.println(finalMove);
	    return finalMove;
	}
	
	@PostMapping("/blackMove")
	public FinalMove blackMove (@RequestBody Pieces pieces) {
		BoardConverter converter = new BoardConverter();
		List<Color> piecesList = converter.convert(pieces);
		Board board = new Board(piecesList, Color.BLACK);
		MiniMax minimax = new MiniMax(5);
		FinalMove finalMove = minimax.execute(board);
		System.out.println(finalMove);
	    return finalMove;
	}
}