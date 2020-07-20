package com.dt.ninemansmorris.board;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.dt.ninemansmorris.move.Move;
import com.dt.ninemansmorris.piece.EmptyTile;
import com.dt.ninemansmorris.piece.FlyingStone;
import com.dt.ninemansmorris.piece.Piece;
import com.dt.ninemansmorris.piece.Stone;
import com.dt.ninemansmorris.player.BlackPlayer;
import com.dt.ninemansmorris.player.Player;
import com.dt.ninemansmorris.player.WhitePlayer;

public class Board {

	private final List<Color> pieceColorList;
	private final List<Piece> gameBoard;
	private Color currentPlayer;
	Player whitePlayer;
	Player blackPlayer;

	public Board (List<Color> pieceColorList, Color playerColor) {
		this.pieceColorList = pieceColorList;
		this.gameBoard = createGameBoard();
		this.currentPlayer = playerColor;
		whitePlayer = new WhitePlayer(this, Color.WHITE, this.gameBoard);
		blackPlayer = new BlackPlayer (this, Color.BLACK, gameBoard);
	}

	private List<Piece> createGameBoard() {
		List<Piece> pieceList = new ArrayList<Piece>();
		boolean isWhiteFlying = checkIsPlayerFlying(Color.WHITE);
		boolean isBlackFlying = checkIsPlayerFlying(Color.BLACK);
		for (int i=0 ; i<42 ; i++) {
			switch (pieceColorList.get(i)) {
			case WHITE:
				if (isWhiteFlying || i > 23) {
					pieceList.add(new FlyingStone(pieceColorList, i, Color.WHITE));
				} else {
					pieceList.add(new Stone(pieceColorList, i, Color.WHITE));
				}
				break;
				
			case BLACK:
				if (isBlackFlying || i > 23) {
					pieceList.add(new FlyingStone(pieceColorList, i, Color.BLACK));
				} else {
					pieceList.add(new Stone(pieceColorList, i, Color.BLACK));
				}
				break;
			case EMPTY:
				pieceList.add(new EmptyTile(i));
			default:
				break;
			}
		}
		return Collections.unmodifiableList(pieceList);
	}

	public List<Piece> getGameBoard() {
		return gameBoard;
	}
	
	public boolean checkIsPlayerFlying(Color playerColor) {
		int count = 0;
		for (Color color : pieceColorList) {
			if (color == playerColor) {
				count += 1;
				if (count > 3)
					return false;
			}
		}
		return true;
	}

	public List<Move> getAllLegalMoves() {
		if (currentPlayer == Color.WHITE) {
			return whitePlayer.getLegalMoves();
		} else {
			return blackPlayer.getLegalMoves();
		}
	}

	public Player currentPlayer() {
		return currentPlayer == Color.WHITE ? whitePlayer : blackPlayer;
	}

	public List<Color> getPieceColorList() {
		return pieceColorList;
	}

	public Color getCurrentPlayerColor() {
		return currentPlayer;
	}

	public Player whitePlayer() {
		return this.whitePlayer;
	}

	public Player blackPlayer() {
		return blackPlayer;
	}
}
