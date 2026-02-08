package com.kakao.onboarding.precource.dukeyun.baseball;

public class ReplayableGameSystem implements GameSystem {

	private final ReplayableGameSystemView systemView;
	private final Game game;

	public ReplayableGameSystem(ReplayableGameSystemView systemView, Game game) {
		this.systemView = systemView;
		this.game = game;
	}

	@Override
	public void run() {
		boolean replay = false;
		while (!replay) {
			game.init();
			game.play();
			replay = systemView.requestReplayInput();
		}
	}
}
