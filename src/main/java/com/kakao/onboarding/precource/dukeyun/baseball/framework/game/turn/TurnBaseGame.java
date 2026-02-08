package com.kakao.onboarding.precource.dukeyun.baseball.framework.game.turn;

import com.kakao.onboarding.precource.dukeyun.baseball.framework.game.Game;

public class TurnBaseGame implements Game {

	private final TurnBaseGameView turnBaseGameView;
	private final TurnBaseGameService turnBaseGameService;

	public TurnBaseGame(TurnBaseGameView turnBaseGameView, TurnBaseGameService turnBaseGameService) {
		this.turnBaseGameView = turnBaseGameView;
		this.turnBaseGameService = turnBaseGameService;
	}

	@Override
	public void init() {
		turnBaseGameService.init();
	}

	@Override
	public void play() {
		turnBaseGameView.printStart();

		while (true) {
			try {
				TurnResult turnResult = turnBaseGameService.playTurn(turnBaseGameView.requestTurnInput());
				turnBaseGameView.printResult(turnResult);
				if (turnResult.isGameCleared()) {
					turnBaseGameView.printClear();
					return;
				}
			} catch (IllegalArgumentException e) {
				System.out.println("[ERROR] " + e.getMessage());
			}
		}
	}
}
