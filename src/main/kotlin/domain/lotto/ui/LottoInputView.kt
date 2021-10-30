package domain.lotto.ui

import global.strategy.ConsoleInputStrategy
import global.strategy.ConsoleOutputStrategy

class LottoInputView(
    private val consoleInputStrategy: ConsoleInputStrategy,
    private val consoleOutputStrategy: ConsoleOutputStrategy
) {

    fun purchaseLotto(): Int {
        consoleOutputStrategy.output(PURCHASE_MESSAGE)
        val money = consoleInputStrategy.input() ?: throw RuntimeException()
        return money.toInt()
    }

    companion object {
        private const val PURCHASE_MESSAGE = "구입금액을 입력해 주세요."
    }
}
