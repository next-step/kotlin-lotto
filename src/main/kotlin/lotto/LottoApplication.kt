package lotto

import lotto.service.LottoShop
import lotto.view.InputView
import lotto.view.OutputView

class LottoApplication {
    fun play() {
        val money = InputView.readMoney()
        val lottos = LottoShop.buyAutoLottos(money)
        OutputView.printDetails(lottos)

        val winningNumbers = InputView.readWinningNumbers()
        OutputView.printResult(lottos, winningNumbers)
    }
}

fun main() {
    LottoApplication().play()
}
