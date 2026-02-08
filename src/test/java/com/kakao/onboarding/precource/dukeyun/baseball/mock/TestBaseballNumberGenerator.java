package com.kakao.onboarding.precource.dukeyun.baseball.mock;

import java.util.List;

import com.kakao.onboarding.precource.dukeyun.baseball.baseball.BaseballGameConfig;
import com.kakao.onboarding.precource.dukeyun.baseball.baseball.BaseballNumber;
import com.kakao.onboarding.precource.dukeyun.baseball.baseball.BaseballNumberGenerator;

public class TestBaseballNumberGenerator implements BaseballNumberGenerator {
	private final List<Integer> fixedNumbers;

	public TestBaseballNumberGenerator(List<Integer> fixedNumbers) {
		this.fixedNumbers = fixedNumbers;
	}

	@Override
	public BaseballNumber generate() {
		return new BaseballNumber(new BaseballGameConfig(3, 1, 9), fixedNumbers);
	}
}