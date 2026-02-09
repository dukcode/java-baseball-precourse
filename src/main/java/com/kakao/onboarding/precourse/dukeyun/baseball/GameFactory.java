package com.kakao.onboarding.precourse.dukeyun.baseball;

import com.kakao.onboarding.precourse.dukeyun.baseball.baseball.BaseballGameConfig;
import com.kakao.onboarding.precourse.dukeyun.baseball.baseball.BaseballGameConsoleView;
import com.kakao.onboarding.precourse.dukeyun.baseball.baseball.BaseballGameService;
import com.kakao.onboarding.precourse.dukeyun.baseball.baseball.RandomBaseballNumberGenerator;
import com.kakao.onboarding.precourse.dukeyun.baseball.framework.game.Game;
import com.kakao.onboarding.precourse.dukeyun.baseball.framework.game.turn.TurnBaseGame;
import com.kakao.onboarding.precourse.dukeyun.baseball.framework.gamesystem.GameSystem;
import com.kakao.onboarding.precourse.dukeyun.baseball.framework.gamesystem.ReplayableGameSystem;
import com.kakao.onboarding.precourse.dukeyun.baseball.framework.gamesystem.ReplayableGameSystemConsoleView;

public class GameFactory {
	private GameFactory() {
	}

	public static BaseballGameConfig baseballGameConfig() {
		return new BaseballGameConfig(3, 1, 9);
	}

	public static GameSystem createBaseballGameSystem() {
		return createBaseballGameSystem(baseballGameConfig());
	}

	public static GameSystem createBaseballGameSystem(BaseballGameConfig config) {
		return new ReplayableGameSystem(new ReplayableGameSystemConsoleView(), createBaseballGame(config));
	}

	private static Game createBaseballGame(BaseballGameConfig config) {
		return new TurnBaseGame(
			new BaseballGameConsoleView(config),
			new BaseballGameService(config, new RandomBaseballNumberGenerator(config))
		);
	}
}
