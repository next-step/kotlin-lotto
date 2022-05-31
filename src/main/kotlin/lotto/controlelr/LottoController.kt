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
        val autoPurchaseRecord = getAutoLottos(numberOfLotto - manualPurchaseRecord.lottoList.size)

        val purchaseRecord = manualPurchaseRecord.concat(autoPurchaseRecord)
        ResultView.printPurchaseRecord(purchaseRecord)

        val winnerNumbers = InputView.getWinner()
        val winnerStat = WinnerStat(purchaseRecord, winnerNumbers)
        ResultView.printWinnerStat(winnerStat)
    }

    private fun getAutoLottos(count: Int): PurchaseRecord {
        return PurchaseRecord(Lotto.getAutoLotto(count))
    }

    private fun getManualLottos(limit: Int): PurchaseRecord {
        val numOfManual = InputView.getNumberOfManual(limit)
        return PurchaseRecord(InputView.getManualLotto(numOfManual))
    }

    private fun getNumberOfLotto(): Int {
        return Payment(InputView.getCash()).getAvailableNumberOfLotto()
    }
}

fun main() {
    LottoController().run()
}
