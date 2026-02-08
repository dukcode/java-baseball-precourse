package com.kakao.onboarding.precource.dukeyun.baseball.baseball;

import static org.assertj.core.api.Assertions.assertThat;

import com.kakao.onboarding.precource.dukeyun.baseball.mock.TestBaseballNumberGenerator;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class BaseballGameServiceTest {

	private BaseballGameService baseballGameService;

	@BeforeEach
	public void init() {
		baseballGameService = new BaseballGameService(new TestBaseballNumberGenerator(List.of(1, 2, 3)));
		baseballGameService.init();
	}

	@Test
	public void 정답_시_결과_객체에_클리어_정보를_반환한다() throws Exception {
		// given
		BaseballGameTurnInput input = new BaseballGameTurnInput("123");

		// when
		BaseballGameTurnResult result = (BaseballGameTurnResult) baseballGameService.playTurn(input);

		//then
		assertThat(result.isGameCleared()).isTrue();
		assertThat(result.getNumBall()).isEqualTo(0);
		assertThat(result.getNumStrike()).isEqualTo(3);
	}

	@Test
	public void 정답이_아닐_시_결과_객체에_클리어_실패_정보를_반환한다() throws Exception {
		// given
		BaseballGameTurnInput input = new BaseballGameTurnInput("132");

		// when
		BaseballGameTurnResult result = (BaseballGameTurnResult) baseballGameService.playTurn(input);

		//then
		assertThat(result.isGameCleared()).isFalse();
		assertThat(result.getNumBall()).isEqualTo(2);
		assertThat(result.getNumStrike()).isEqualTo(1);
	}

	@Test
	public void 모두_틀리면_볼과_스트라이크_모두_0이다() throws Exception {
		// given
		BaseballGameTurnInput input = new BaseballGameTurnInput("456");

		// when
		BaseballGameTurnResult result = (BaseballGameTurnResult) baseballGameService.playTurn(input);

		//then
		assertThat(result.isGameCleared()).isFalse();
		assertThat(result.getNumBall()).isEqualTo(0);
		assertThat(result.getNumStrike()).isEqualTo(0);
	}

	@Test
	public void 모두_자리만_다르면_3볼이다() throws Exception {
		// given
		BaseballGameTurnInput input = new BaseballGameTurnInput("312");

		// when
		BaseballGameTurnResult result = (BaseballGameTurnResult) baseballGameService.playTurn(input);

		//then
		assertThat(result.isGameCleared()).isFalse();
		assertThat(result.getNumBall()).isEqualTo(3);
		assertThat(result.getNumStrike()).isEqualTo(0);
	}
}