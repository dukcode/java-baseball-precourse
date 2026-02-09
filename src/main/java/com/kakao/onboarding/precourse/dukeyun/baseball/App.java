package com.kakao.onboarding.precourse.dukeyun.baseball;

import com.kakao.onboarding.precourse.dukeyun.baseball.framework.gamesystem.GameSystem;

public class App {

	public static void main(String[] args) {
		GameSystem baseballGameSystem = GameFactory.createBaseballGameSystem();
		baseballGameSystem.run();
	}

}
