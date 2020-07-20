package com.dt.ninemansmorris.engine;

import com.dt.ninemansmorris.board.Board;
import com.dt.ninemansmorris.player.Player;

public final class BoardEvaluator{

    private final static int MOBILITY_MULTIPLIER = 10;
    private static final BoardEvaluator INSTANCE = new BoardEvaluator();

    private BoardEvaluator() {
    }

    public static BoardEvaluator get() {
        return INSTANCE;
    }

    public int evaluate(final Board board,
                        final int depth) {
        return score(board.whitePlayer(), depth) - score(board.blackPlayer(), depth);
    }

    private static int score(final Player player,
                             final int depth) {
        return mobility(player) + pieceEvaluations(player) + depthBonus(depth) + gameOver(player);
    }

	private static int gameOver(Player player) {
		if (player.getPieceCount() < 3) return -3000;
		if (player.getOpponent().getPieceCount() < 3) return 3000;
		return 0;
	}

	private static int pieceEvaluations(final Player player) {
        return player.getPieceCount() * 100;
    }

    private static int mobility(final Player player) {
        return MOBILITY_MULTIPLIER * (player.getLegalMoves().size() - player.getOpponent().getLegalMoves().size());
    }

    private static int depthBonus(final int depth) {
        return depth == 0 ? 1 : 10 * depth;
    }
}
