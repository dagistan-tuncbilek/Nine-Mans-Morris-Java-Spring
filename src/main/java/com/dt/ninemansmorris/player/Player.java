package com.dt.ninemansmorris.player;

import java.util.List;

import com.dt.ninemansmorris.board.Board;
import com.dt.ninemansmorris.board.Color;
import com.dt.ninemansmorris.engine.MoveTransition;
import com.dt.ninemansmorris.move.Move;
import com.dt.ninemansmorris.piece.Piece;

public abstract class Player {

	private Board board;
	private Color color;
	private List<Piece> gameBoard;
	private List<Move> legalMoves;
	private int pieceCount;
	
	public Player(Board board, Color color, List<Piece> gameBoard) {
		this.board = board;
		this.color = color;
		this.gameBoard = gameBoard;
	}
	
	public abstract List<Move> calculateAllLegalMoves();
	
	public abstract MoveTransition makeMove (Move move);
	
	public abstract Player getOpponent();
	
	public Color getColor() {
		return color;
	}

	public List<Piece> getGameBoard() {
		return gameBoard;
	}
	
	public Board getBoard() {
		return board;
	}

	public List<Move> getLegalMoves() {
		return legalMoves;
	}

	public void setLegalMoves(List<Move> allLegalMoves) {
		this.legalMoves = allLegalMoves;
	}

	public int getPieceCount() {
		return pieceCount;
	}

	public void setPieceCount(int pieceCount) {
		this.pieceCount = pieceCount;
	}
}
