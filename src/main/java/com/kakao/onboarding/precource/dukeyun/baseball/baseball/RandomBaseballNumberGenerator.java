package com.kakao.onboarding.precource.dukeyun.baseball.baseball;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RandomBaseballNumberGenerator implements BaseballNumberGenerator {

	private static final Random RANDOM = new Random();

	private final BaseballGameConfig config;

	public RandomBaseballNumberGenerator() {
		this(new BaseballGameConfig(3, 1, 9));
	}

	public RandomBaseballNumberGenerator(BaseballGameConfig config) {
		this.config = config;
	}

	@Override
	public BaseballNumber generate() {
		List<Integer> numbers = new ArrayList<>();
		while (numbers.size() < config.getLength()) {
			int randomNumber = RANDOM.nextInt(config.getMinRange(), config.getMaxRange() + 1);
			if (!numbers.contains(randomNumber)) {
				numbers.add(randomNumber);
			}
		}

		return new BaseballNumber(config, numbers);
	}

}
