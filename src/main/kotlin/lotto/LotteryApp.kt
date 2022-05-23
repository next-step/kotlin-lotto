package lotto

import lotto.ui.LotteryRandomGeneratorView
import lotto.ui.LottoInputView

object LotteryApp {
    fun launch() {
        val numberOfLotteries = LottoInputView.getPurchaseAmount()
        LotteryRandomGeneratorView.display(numberOfLotteries)
    }
}

fun main() {
    LotteryApp.launch()
}
