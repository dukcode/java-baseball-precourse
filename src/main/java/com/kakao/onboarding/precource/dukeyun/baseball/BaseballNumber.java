package com.kakao.onboarding.precource.dukeyun.baseball;

import java.util.List;

public class BaseballNumber {

	private static final int LEN = 3;
	private static final int MIN_RANGE = 0;
	private static final int MAX_RANGE = 9;

	private final List<Integer> numbers;

	public BaseballNumber(List<Integer> numbers) {
		checkLength(numbers);
		checkNumbersRange(numbers);
		checkDuplication(numbers);
		this.numbers = numbers;
	}

	private void checkDuplication(List<Integer> numbers) {
		int[] freq = new int[MAX_RANGE - MIN_RANGE + 1];
		for (int number : numbers) {
			int index = number - MIN_RANGE;
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
		if (number < MIN_RANGE || MAX_RANGE < number) {
			throw new RuntimeException(
				String.format("숫자 범위는 %d 이상 %d 이하여야 합니다. (문제 숫자: %d)", MIN_RANGE, MAX_RANGE, number));
		}
	}

	private void checkLength(List<Integer> numbers) {
		if (numbers.size() != LEN) {
			throw new RuntimeException(String.format("숫자야구 길이는 %d이어야 합니다.(현재 길이 : %d)", LEN, numbers.size()));
		}
	}

	public int countStrike(BaseballNumber baseballNumber) {
		int count = 0;

		for (int index = 0; index < LEN; index++) {
			if (numbers.get(index).equals(baseballNumber.numbers.get(index))) {
				count++;
			}
		}

		return count;
	}

}
