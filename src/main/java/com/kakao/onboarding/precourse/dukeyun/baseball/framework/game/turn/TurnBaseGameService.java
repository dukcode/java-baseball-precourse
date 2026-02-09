package com.kakao.onboarding.precourse.dukeyun.baseball.framework.game.turn;

public interface TurnBaseGameService {

	void init();

	TurnResult playTurn(TurnInput turnInput);

}
