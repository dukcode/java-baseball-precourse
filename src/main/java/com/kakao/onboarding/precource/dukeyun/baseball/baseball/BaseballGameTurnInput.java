package com.kakao.onboarding.precource.dukeyun.baseball.baseball;

import java.util.ArrayList;
import java.util.List;

import com.kakao.onboarding.precource.dukeyun.baseball.framework.game.turn.TurnInput;

public class BaseballGameTurnInput implements TurnInput {

	private final BaseballNumber baseballNumber;

	public BaseballGameTurnInput(String input) {
		valid(input);
		this.baseballNumber = createBaseballNumber(input);
	}

	private BaseballNumber createBaseballNumber(String input) {
		List<Integer> numbers = new ArrayList<>();
		for (char ch : input.toCharArray()) {
			numbers.add(ch - '0');
		}
		return new BaseballNumber(numbers);
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
