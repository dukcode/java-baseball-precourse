package com.kakao.onboarding.precourse.dukeyun.baseball.baseball;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class BaseballGameTurnInputTest {

	@Test
	public void 숫자가_아니면_예외를_발생시킨다() throws Exception {
		assertThatThrownBy(() -> {
			new BaseballGameTurnInput(new BaseballGameConfig(3, 1, 9), "1aa");
		}).isInstanceOf(IllegalArgumentException.class);
	}
}