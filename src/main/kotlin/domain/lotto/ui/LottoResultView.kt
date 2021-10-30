package domain.lotto.ui

import global.strategy.ConsoleOutputStrategy

class LottoResultView(private val consoleOutputStrategy: ConsoleOutputStrategy) {
    fun announceNumberOfPurchases(numberOfPurchases: Int) {
        consoleOutputStrategy.output(NUMBER_OF_PURCHASES_MESSAGE.format(numberOfPurchases))
    }

    companion object {
        private const val NUMBER_OF_PURCHASES_MESSAGE = "%s개를 구매했습니다."
    }
}
