package lotto

import lotto.service.LottoShop
import lotto.view.InputView
import lotto.view.OutputView

object LottoApplication {
    @JvmStatic
    fun main(args: Array<String>) {
        val money = InputView.readMoney()
        val lottos = LottoShop.buyAutoLottos(money)
        OutputView.printDetails(lottos)

        val winningNumbers = InputView.readWinningNumbers()
        OutputView.printResult(lottos, winningNumbers)
    }
}
