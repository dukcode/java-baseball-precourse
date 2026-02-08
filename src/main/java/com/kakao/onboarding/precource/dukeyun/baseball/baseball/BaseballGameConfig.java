package com.kakao.onboarding.precource.dukeyun.baseball.baseball;

public class BaseballGameConfig {

	private static final int DEFAULT_LENGTH = 3;
	private static final int DEFAULT_MIN_RANGE = 1;
	private static final int DEFAULT_MAX_RANGE = 9;

	private final int length;
	private final int minRange;
	private final int maxRange;

	public BaseballGameConfig() {
		this(DEFAULT_LENGTH, DEFAULT_MIN_RANGE, DEFAULT_MAX_RANGE);
	}

	public BaseballGameConfig(int length, int minRange, int maxRange) {
		validateConfig(length, minRange, maxRange);
		this.length = length;
		this.minRange = minRange;
		this.maxRange = maxRange;
	}

	private void validateConfig(int length, int minRange, int maxRange) {
		if (length <= 0) {
			throw new RuntimeException("길이는 양수여야 합니다.");
		}
		if (minRange >= maxRange) {
			throw new RuntimeException("최소값은 최대값보다 작아야 합니다.");
		}
		int availableNumbers = maxRange - minRange + 1;
		if (length > availableNumbers) {
			throw new RuntimeException(
				String.format("길이(%d)가 사용 가능한 숫자의 개수(%d)보다 큽니다.", length, availableNumbers));
		}
	}

	public int getLength() {
		return length;
	}

	public int getMinRange() {
		return minRange;
	}

	public int getMaxRange() {
		return maxRange;
	}
}