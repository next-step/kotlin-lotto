package domain.lotto.ui

import global.strategy.ui.ConsoleInputStrategy
import global.strategy.ui.ConsoleOutputStrategy

class LottoInputView(
    private val consoleInputStrategy: ConsoleInputStrategy,
    private val consoleOutputStrategy: ConsoleOutputStrategy
) {

    fun purchaseLotto(): Int {
        consoleOutputStrategy.output(PURCHASE_MESSAGE)
        val money = consoleInputStrategy.input() ?: throw RuntimeException()
        return money.toInt()
    }

    fun winningLotto(): String {
        consoleOutputStrategy.output(WINNING_LOTTO_MESSAGE)
        return consoleInputStrategy.input() ?: throw RuntimeException()
    }

    fun bonusBall(): Int {
        consoleOutputStrategy.output(BONUS_BALL_MESSAGE)
        val bonusBall = consoleInputStrategy.input() ?: throw RuntimeException()
        return bonusBall.toInt()
    }

    companion object {
        private const val PURCHASE_MESSAGE = "구입금액을 입력해 주세요."
        private const val WINNING_LOTTO_MESSAGE = "지난 주 당첨 번호를 입력해 주세요."
        private const val BONUS_BALL_MESSAGE = "보너스 볼을 입력해 주세요."
    }
}
