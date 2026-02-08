package com.kakao.onboarding.precource.dukeyun.baseball.baseball;

import com.kakao.onboarding.precource.dukeyun.baseball.framework.game.turn.TurnResult;

public class BaseballGameTurnResult implements TurnResult {

	private final boolean clear;
	private final int numStrike;
	private final int numBall;

	public BaseballGameTurnResult(boolean clear, int numStrike, int numBall) {
		this.clear = clear;
		this.numStrike = numStrike;
		this.numBall = numBall;
	}

	@Override
	public boolean isGameCleared() {
		return clear;
	}

	public int getNumStrike() {
		return numStrike;
	}

	public int getNumBall() {
		return numBall;
	}
}
