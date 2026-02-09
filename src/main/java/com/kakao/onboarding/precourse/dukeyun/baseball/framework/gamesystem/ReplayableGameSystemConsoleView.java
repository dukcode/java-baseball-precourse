package com.kakao.onboarding.precourse.dukeyun.baseball.framework.gamesystem;

import com.kakao.onboarding.precourse.dukeyun.baseball.utils.Console;

public class ReplayableGameSystemConsoleView implements ReplayableGameSystemView {

	private static final String RESTART = "1";
	private static final String EXIT = "2";
	private static final String REPLAY_REQUEST_PROMPT = "게임을 새로 시작하려면 " + RESTART + ", 종료하려면 " + EXIT + "를 입력하세요.";

	@Override
	public boolean requestReplayInput() {
		System.out.println(REPLAY_REQUEST_PROMPT);
		String input = Console.readLine();
		validInput(input);
		return isReplay(input);
	}

	private void validInput(String input) {
		if (!input.equals(RESTART) && !input.equals(EXIT)) {
			throw new IllegalArgumentException("입력은 " + RESTART + " 이거나" + EXIT + " 여야 합니다.");
		}
	}

	private boolean isReplay(String input) {
		return input.equals(RESTART);
	}
}
