package com.kakao.onboarding.precource.dukeyun.baseball.baseball;

import static org.assertj.core.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;

class BaseballNumberTest {
	@Test
	void 기준_길이보다_길면_생성이_안된다() {
		assertThatThrownBy(() ->
			new BaseballNumber(List.of(1, 2, 3, 4))
		).isInstanceOf(RuntimeException.class);
	}

	@Test
	void 기준_길이보다_짧으면_생성이_안된다() {
		assertThatThrownBy(() ->
			new BaseballNumber(List.of(1, 2))
		).isInstanceOf(RuntimeException.class);
	}

	@Test
	void 숫자가_범위가_최소_허용_범위보다_작으면_생성이_안된다() {
		assertThatThrownBy(() ->
			new BaseballNumber(List.of(-1, 2, 3))
		).isInstanceOf(RuntimeException.class);
	}

	@Test
	void 숫자가_범위가_최소_허용_범위보다_크면_생성이_안된다() {
		assertThatThrownBy(() ->
			new BaseballNumber(List.of(10, 2, 3))
		).isInstanceOf(RuntimeException.class);
	}

	@Test
	void 중복된_숫자로_생성할_수_없다() {
		assertThatThrownBy(() ->
			new BaseballNumber(List.of(1, 1, 3))
		).isInstanceOf(RuntimeException.class);
	}

	@Test
	void 올바른_조건으로_생성할_수_있다() {
		assertThatCode(
			() -> new BaseballNumber(List.of(1, 2, 3))
		).doesNotThrowAnyException();
	}

	@Test
	void 스트라이크_갯수를_계산할_수_있다() {
		BaseballNumber systemNumber = new BaseballNumber(List.of(1, 2, 3));

		assertThat(systemNumber.countStrike(new BaseballNumber(List.of(1, 2, 3)))).isEqualTo(3);
		assertThat(systemNumber.countStrike(new BaseballNumber(List.of(1, 2, 4)))).isEqualTo(2);
		assertThat(systemNumber.countStrike(new BaseballNumber(List.of(1, 3, 4)))).isEqualTo(1);
		assertThat(systemNumber.countStrike(new BaseballNumber(List.of(3, 2, 1)))).isEqualTo(1);
		assertThat(systemNumber.countStrike(new BaseballNumber(List.of(4, 5, 6)))).isEqualTo(0);
		assertThat(systemNumber.countStrike(new BaseballNumber(List.of(3, 1, 2)))).isEqualTo(0);
	}

	@Test
	void 볼_갯수를_계산할_수_있다() {
		BaseballNumber systemNumber = new BaseballNumber(List.of(1, 2, 3));

		assertThat(systemNumber.countBall(new BaseballNumber(List.of(1, 2, 3)))).isEqualTo(0);
		assertThat(systemNumber.countBall(new BaseballNumber(List.of(1, 2, 4)))).isEqualTo(0);
		assertThat(systemNumber.countBall(new BaseballNumber(List.of(1, 3, 4)))).isEqualTo(1);
		assertThat(systemNumber.countBall(new BaseballNumber(List.of(3, 2, 1)))).isEqualTo(2);
		assertThat(systemNumber.countBall(new BaseballNumber(List.of(4, 5, 6)))).isEqualTo(0);
		assertThat(systemNumber.countBall(new BaseballNumber(List.of(3, 1, 2)))).isEqualTo(3);
	}
}