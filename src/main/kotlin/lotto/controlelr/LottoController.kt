package lotto.controlelr

import lotto.domain.LottoShop
import lotto.domain.Payment
import lotto.domain.PurchaseRecord
import lotto.domain.WinnerStat
import lotto.view.InputView
import lotto.view.ResultView

class LottoController {
    fun run() {
        val numberOfLotto = getNumberOfLotto()
        val manualPurchaseRecord = getManualLottos(numberOfLotto)
        val autoPurchaseRecord = LottoShop().purchase(numberOfLotto - manualPurchaseRecord.lottoList.size)
        val purchaseRecord = manualPurchaseRecord.concat(autoPurchaseRecord)
        ResultView.printPurchaseRecord(purchaseRecord)

        val winnerNumbers = InputView.getWinner()
        val winnerStat = WinnerStat(purchaseRecord, winnerNumbers)
        ResultView.printWinnerStat(winnerStat)
    }

    private fun getManualLottos(limit: Int): PurchaseRecord {
        val numOfManual = InputView.getNumberOfManual(limit)
        return PurchaseRecord(InputView.getManualLotto(numOfManual))
    }

    private fun getNumberOfLotto(): Int {
        val payment = Payment(InputView.getCash())
        return LottoShop.getAvailableNumberOfLotto(payment)
    }
}

fun main() {
    LottoController().run()
}
