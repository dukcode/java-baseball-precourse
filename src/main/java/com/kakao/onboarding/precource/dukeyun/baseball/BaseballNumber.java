package com.kakao.onboarding.precource.dukeyun.baseball;

import java.util.List;

public class BaseballNumber {

	private static final int LEN = 3;
	private static final int MIN_RANGE = 0;
	private static final int MAX_RANGE = 9;

	private final List<Integer> numbers;

	public BaseballNumber(List<Integer> numbers) {
		checkLength(numbers);
		checkRange(numbers);
		this.numbers = numbers;
	}

	private static void checkRange(List<Integer> numbers) {
		for (int number : numbers) {
			if (number < MIN_RANGE || MAX_RANGE < number) {
				throw new RuntimeException(
					String.format("숫자 범위는 %d 이상 %d 이하여야 합니다. (문제 숫자: %d)", MIN_RANGE, MAX_RANGE, number));
			}
		}
	}

	private static void checkLength(List<Integer> numbers) {
		if (numbers.size() != LEN) {
			throw new RuntimeException(String.format("숫자야구 길이는 %d이어야 합니다.(현재 길이 : %d)", LEN, numbers.size()));
		}
	}

}
