package com.kakao.onboarding.precource.dukeyun.baseball.framework.game.turn;

public interface TurnBaseGameView {

	void printStart();

	TurnInput requestTurnInput();

	void printClear();

	void printResult(TurnResult turnResult);

}
