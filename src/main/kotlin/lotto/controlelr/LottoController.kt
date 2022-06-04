package lotto.controlelr

import lotto.domain.Lotto
import lotto.domain.Payment
import lotto.domain.PurchaseRecord
import lotto.domain.WinnerStat
import lotto.view.InputView
import lotto.view.ResultView

class LottoController {
    fun run() {
        val numberOfLotto = getNumberOfLotto()
        val manualPurchaseRecord = getManualLottos(numberOfLotto)
        val purchaseRecord = PurchaseRecord.purchase(manualPurchaseRecord, numberOfLotto)
        ResultView.printPurchaseRecord(purchaseRecord)

        val winnerNumbers = InputView.getWinner()
        val winnerStat = WinnerStat(purchaseRecord, winnerNumbers)
        ResultView.printWinnerStat(winnerStat)
    }

    private fun getManualLottos(limit: Int): List<Lotto> {
        val numOfManual = InputView.getNumberOfManual(limit)
        return InputView.getManualLotto(numOfManual)
    }

    private fun getNumberOfLotto(): Int {
        return Payment(InputView.getCash()).getAvailableNumberOfLotto()
    }
}

fun main() {
    LottoController().run()
}
