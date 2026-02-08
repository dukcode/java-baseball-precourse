package com.kakao.onboarding.precource.dukeyun.baseball;

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
			TurnResult turnResult = turnBaseGameService.playTurn(turnBaseGameView.requestTurnInput());
			turnBaseGameView.printResult(turnResult);
			if (turnResult.isGameCleared()) {
				turnBaseGameView.printClear();
				return;
			}
		}
	}
}
