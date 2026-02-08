package com.kakao.onboarding.precource.dukeyun.baseball.baseball;

import java.util.List;

public class BaseballNumber {

	private final BaseballGameConfig config;
	private final List<Integer> numbers;

	public BaseballNumber(List<Integer> numbers) {
		this(new BaseballGameConfig(), numbers);
	}

	public BaseballNumber(BaseballGameConfig config, List<Integer> numbers) {
		this.config = config;
		checkLength(numbers);
		checkNumbersRange(numbers);
		checkDuplication(numbers);
		this.numbers = numbers;
	}

	private void checkDuplication(List<Integer> numbers) {
		int[] freq = new int[config.getMaxRange() - config.getMinRange() + 1];
		for (int number : numbers) {
			int index = number - config.getMinRange();
			freq[index]++;
			if (freq[index] > 1) {
				throw new RuntimeException(String.format("숫자가 중복 되었습니다.(중복 숫자: %d)", number));
			}
		}
	}

	private void checkNumbersRange(List<Integer> numbers) {
		for (int number : numbers) {
			checkNumberRange(number);
		}
	}

	private void checkNumberRange(int number) {
		if (number < config.getMinRange() || config.getMaxRange() < number) {
			throw new RuntimeException(
				String.format("숫자 범위는 %d 이상 %d 이하여야 합니다. (문제 숫자: %d)", config.getMinRange(), config.getMaxRange(), number));
		}
	}

	private void checkLength(List<Integer> numbers) {
		if (numbers.size() != config.getLength()) {
			throw new RuntimeException(String.format("숫자야구 길이는 %d이어야 합니다.(현재 길이 : %d)", config.getLength(), numbers.size()));
		}
	}

	public int countStrike(BaseballNumber baseballNumber) {
		int count = 0;

		for (int index = 0; index < config.getLength(); index++) {
			if (numbers.get(index).equals(baseballNumber.numbers.get(index))) {
				count++;
			}
		}

		return count;
	}

	public int countBall(BaseballNumber baseballNumber) {
		int count = 0;

		for (int pivotIndex = 0; pivotIndex < config.getLength(); pivotIndex++) {
			for (int index = 0; index < config.getLength(); index++) {
				if (pivotIndex == index) {
					continue;
				}

				if (numbers.get(pivotIndex).equals(baseballNumber.numbers.get(index))) {
					count++;
				}
			}
		}

		return count;
	}
}
