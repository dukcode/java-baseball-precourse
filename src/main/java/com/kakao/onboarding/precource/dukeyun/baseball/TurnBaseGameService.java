package com.kakao.onboarding.precource.dukeyun.baseball;

public interface TurnBaseGameService {

	void init();

	TurnResult playTurn(TurnInput turnInput);

}
