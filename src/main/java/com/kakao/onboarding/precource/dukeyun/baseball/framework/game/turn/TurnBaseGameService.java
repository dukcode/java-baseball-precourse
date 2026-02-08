package com.kakao.onboarding.precource.dukeyun.baseball.framework.game.turn;

public interface TurnBaseGameService {

	void init();

	TurnResult playTurn(TurnInput turnInput);

}
