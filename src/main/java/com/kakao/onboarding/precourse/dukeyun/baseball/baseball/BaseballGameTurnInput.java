package com.kakao.onboarding.precourse.dukeyun.baseball.baseball;

import java.util.ArrayList;
import java.util.List;

import com.kakao.onboarding.precourse.dukeyun.baseball.framework.game.turn.TurnInput;

public class BaseballGameTurnInput implements TurnInput {

	private final BaseballNumber baseballNumber;

	public BaseballGameTurnInput(BaseballGameConfig config, String input) {
		valid(input);
		this.baseballNumber = createBaseballNumber(config, input);
	}

	private BaseballNumber createBaseballNumber(BaseballGameConfig config, String input) {
		List<Integer> numbers = new ArrayList<>();
		for (char ch : input.toCharArray()) {
			numbers.add(ch - '0');
		}
		return new BaseballNumber(config, numbers);
	}

	private void valid(String input) {
		for (char ch : input.toCharArray()) {
			validIsNumber(ch);
		}
	}

	private void validIsNumber(char ch) {
		if (!Character.isDigit(ch)) {
			throw new IllegalArgumentException("입력은 숫자여야 합니다.");
		}
	}

	public BaseballNumber getBaseballNumber() {
		return baseballNumber;
	}
}
