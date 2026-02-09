package com.kakao.onboarding.precourse.dukeyun.baseball.baseball;

import com.kakao.onboarding.precourse.dukeyun.baseball.framework.game.turn.TurnBaseGameService;
import com.kakao.onboarding.precourse.dukeyun.baseball.framework.game.turn.TurnInput;
import com.kakao.onboarding.precourse.dukeyun.baseball.framework.game.turn.TurnResult;

public class BaseballGameService implements TurnBaseGameService {

	private final BaseballGameConfig config;
	private final BaseballNumberGenerator baseballNumberGenerator;
	private BaseballNumber answer;

	public BaseballGameService(BaseballGameConfig config, BaseballNumberGenerator baseballNumberGenerator) {
		this.config = config;
		this.baseballNumberGenerator = baseballNumberGenerator;
	}

	@Override
	public void init() {
		this.answer = baseballNumberGenerator.generate();
	}

	@Override
	public TurnResult playTurn(TurnInput turnInput) {
		BaseballGameTurnInput baseballGameTurnInput = (BaseballGameTurnInput)turnInput;
		BaseballNumber baseballNumber = baseballGameTurnInput.getBaseballNumber();

		return calculateResult(baseballNumber);
	}

	private TurnResult calculateResult(BaseballNumber baseballNumber) {
		int numStrike = answer.countStrike(baseballNumber);
		int numBall = answer.countBall(baseballNumber);

		return new BaseballGameTurnResult(isClear(numStrike), numStrike, numBall);
	}

	private boolean isClear(int numStrike) {
		return numStrike == config.getLength();
	}
}
