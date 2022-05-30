package lotto.controlelr

import lotto.domain.LottoShop
import lotto.domain.Payment
import lotto.domain.WinnerStat
import lotto.view.InputView
import lotto.view.ResultView

class LottoController {
    fun run() {
        val cash = InputView.getCash()
        val purchaseRecord = LottoShop().purchase(Payment(cash))
        ResultView.printPurchaseRecord(purchaseRecord)

        val winnerNumbers = InputView.getWinner()
        val winnerStat = WinnerStat(purchaseRecord, winnerNumbers)
        ResultView.printWinnerStat(winnerStat)
    }
}

fun main() {
    LottoController().run()
}
