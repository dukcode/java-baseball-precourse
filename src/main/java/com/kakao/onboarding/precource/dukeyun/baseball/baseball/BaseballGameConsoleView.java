package com.kakao.onboarding.precource.dukeyun.baseball.baseball;

import com.kakao.onboarding.precource.dukeyun.baseball.framework.game.turn.TurnBaseGameView;
import com.kakao.onboarding.precource.dukeyun.baseball.framework.game.turn.TurnInput;
import com.kakao.onboarding.precource.dukeyun.baseball.framework.game.turn.TurnResult;
import com.kakao.onboarding.precource.dukeyun.baseball.utils.Console;

public class BaseballGameConsoleView implements TurnBaseGameView {

	private static final String REQUEST_INPUT_MESSAGE = "숫자를 입력해주세요 : ";
	private static final String CLEAR_MESSAGE_FORMAT = "%d개의 숫자를 모두 맞히셨습니다! 게임 끝";

	private static final String BALL_UNIT = "볼";
	private static final String STRIKE_UNIT = "스트라이크";
	private static final String NOTHING = "낫싱";

	private final BaseballGameConfig config;

	public BaseballGameConsoleView() {
		this(new BaseballGameConfig());
	}

	public BaseballGameConsoleView(BaseballGameConfig config) {
		this.config = config;
	}

	private static void printNumStrike(int numStrike) {
		System.out.printf("%d%s", numStrike, STRIKE_UNIT);
	}

	private static void printNumBall(int numBall) {
		System.out.printf("%d%s ", numBall, BALL_UNIT);
	}

	private static void printNewLine() {
		System.out.println();
	}

	private static void printNothing() {
		System.out.print(NOTHING);
	}

	@Override
	public void printStart() {
	}

	@Override
	public TurnInput requestTurnInput() {
		System.out.print(REQUEST_INPUT_MESSAGE);
		return new BaseballGameTurnInput(Console.readLine());
	}

	@Override
	public void printClear() {
		System.out.printf(CLEAR_MESSAGE_FORMAT + "%n", config.getLength());
	}

	@Override
	public void printResult(TurnResult turnResult) {
		BaseballGameTurnResult baseballGameTurnResult = (BaseballGameTurnResult)turnResult;

		int numBall = baseballGameTurnResult.getNumBall();
		int numStrike = baseballGameTurnResult.getNumStrike();

		if (numBall == 0 && numStrike == 0) {
			printNothing();
			printNewLine();
			return;
		}

		if (numBall != 0) {
			printNumBall(numBall);
		}

		if (numStrike != 0) {
			printNumStrike(numStrike);
		}

		printNewLine();
	}
}
