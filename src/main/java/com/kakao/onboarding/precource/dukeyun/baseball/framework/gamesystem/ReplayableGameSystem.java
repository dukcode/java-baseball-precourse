package com.kakao.onboarding.precource.dukeyun.baseball.framework.gamesystem;

import com.kakao.onboarding.precource.dukeyun.baseball.framework.game.Game;

public class ReplayableGameSystem implements GameSystem {

	private final ReplayableGameSystemView systemView;
	private final Game game;

	public ReplayableGameSystem(ReplayableGameSystemView systemView, Game game) {
		this.systemView = systemView;
		this.game = game;
	}

	@Override
	public void run() {
		boolean replay = true;
		while (replay) {
			game.init();
			game.play();
			replay = inputReplay();
		}
	}

	private boolean inputReplay() {
		try {
			return systemView.requestReplayInput();
		} catch (IllegalArgumentException e) {
			System.out.println("[ERROR] " + e.getMessage());
			return inputReplay();
		}
	}
}
