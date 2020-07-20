package com.dt.ninemansmorris.engine;

import java.util.List;

import com.dt.ninemansmorris.board.Board;
import com.dt.ninemansmorris.entity.FinalMove;
import com.dt.ninemansmorris.move.Move;
import com.dt.ninemansmorris.move.MoveFactory;

public final class MiniMax {

	private final BoardEvaluator evaluator;
	private final int searchDepth;
	private long boardsEvaluated;
	private long executionTime;

	public MiniMax(final int searchDepth) {
		this.evaluator = BoardEvaluator.get();
		this.boardsEvaluated = 0;
		this.searchDepth = searchDepth;
	}

	@Override
	public String toString() {
		return "MiniMax";
	}

	public long getNumBoardsEvaluated() {
		return this.boardsEvaluated;
	}

	public FinalMove execute(final Board board) {
		final long startTime = System.currentTimeMillis();
		Move bestMove = MoveFactory.getNullMove();
		int highestSeenValue = Integer.MIN_VALUE;
		int lowestSeenValue = Integer.MAX_VALUE;
		int currentValue;
		System.out.println(board.currentPlayer() + " THINKING with depth = " + this.searchDepth);
		List<Move> legalMoves = board.currentPlayer().getLegalMoves();
		int moveCounter = 1;
		final int numMoves = legalMoves.size();
		for (final Move move : legalMoves) {
			final MoveTransition moveTransition = board.currentPlayer().makeMove(move);
			System.out.println(moveTransition);
			if (moveTransition.getMoveStatus().isDone()) {
				System.out.println(board.currentPlayer().getColor());
				currentValue = board.currentPlayer().getColor().isWhite()
						? min(moveTransition.getBoard(), this.searchDepth - 1)
						: max(moveTransition.getBoard(), this.searchDepth - 1);
				System.out.println("\t" + toString() + " analyzing move (" + moveCounter + "/" + numMoves + ") " + move
						+ " scores " + currentValue);
				if (board.currentPlayer().getColor().isWhite() && currentValue >= highestSeenValue) {
					highestSeenValue = currentValue;
					bestMove = move;
				} else if (board.currentPlayer().getColor().isBlack() && currentValue <= lowestSeenValue) {
					lowestSeenValue = currentValue;
					bestMove = move;
				}
			} else if (moveTransition.getMoveStatus().isGameOver()){
				currentValue = board.currentPlayer().getColor().isWhite() ? -3000 : 3000;
				if (board.currentPlayer().getColor().isWhite() && currentValue >= highestSeenValue) {
					highestSeenValue = currentValue;
					bestMove = move;
				} else if (board.currentPlayer().getColor().isBlack() && currentValue <= lowestSeenValue) {
					lowestSeenValue = currentValue;
					bestMove = move;
				}
			} else {
				System.out.println(
						"\t" + toString() + " can't execute move (" + moveCounter + "/" + numMoves + ") " + move);
			}
			moveCounter++;
		}

		this.executionTime = System.currentTimeMillis() - startTime;
		System.out.printf("%s SELECTS %s [#boards = %d time taken = %d ms, rate = %.1f\n", board.currentPlayer(),
				bestMove, this.boardsEvaluated, this.executionTime,
				(1000 * ((double) this.boardsEvaluated / this.executionTime)));

		if (this.boardsEvaluated == Integer.MIN_VALUE || this.boardsEvaluated == Integer.MAX_VALUE) {
			System.out.println("somethings wrong with the # of boards evaluated!");
		}

		return new FinalMove(bestMove.getPiece().getPiecePosition(), bestMove.getDestinationCoordinate(), -1);
	}

	private int min(final Board board, final int depth) {
		System.out.println(board.currentPlayer().getLegalMoves());
		if (depth == 0) {
			this.boardsEvaluated++;
			return this.evaluator.evaluate(board, depth);
		}
		if (isEndGameScenario(board)) {
			return this.evaluator.evaluate(board, depth);
		}
		int lowestSeenValue = Integer.MAX_VALUE;
		for (final Move move : board.currentPlayer().getLegalMoves()) {
			final MoveTransition moveTransition = board.currentPlayer().makeMove(move);
			if (moveTransition.getMoveStatus().isDone()) {
				final int currentValue = max(moveTransition.getBoard(), depth - 1);
				if (currentValue <= lowestSeenValue) {
					lowestSeenValue = currentValue;
				}
			}
		}
		return lowestSeenValue;
	}

	private int max(final Board board, final int depth) {
		System.out.println(board.currentPlayer().getLegalMoves());
		if (depth == 0) {
			this.boardsEvaluated++;
			return this.evaluator.evaluate(board, depth);
		}
		if (isEndGameScenario(board)) {
			return this.evaluator.evaluate(board, depth);
		}
		int highestSeenValue = Integer.MIN_VALUE;
		for (final Move move : board.currentPlayer().getLegalMoves()) {
			final MoveTransition moveTransition = board.currentPlayer().makeMove(move);
			if (moveTransition.getMoveStatus().isDone()) {
				final int currentValue = min(moveTransition.getBoard(), depth - 1);
				if (currentValue >= highestSeenValue) {
					highestSeenValue = currentValue;
				}
			}
		}
		return highestSeenValue;
	}

	private static boolean isEndGameScenario(final Board board) {
		return board.currentPlayer().getPieceCount() < 3 || board.currentPlayer().getOpponent().getPieceCount() < 3;
	}

}
