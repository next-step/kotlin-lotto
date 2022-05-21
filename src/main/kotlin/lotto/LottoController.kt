package lotto

import lotto.domain.Lotto
import lotto.domain.LottoMatchReport
import lotto.domain.LottoSeller
import lotto.ui.LottoPurchaseView
import lotto.ui.StatisticsView
import lotto.ui.WinningLottoView

class LottoController {

    private val lottoSeller = LottoSeller()

    fun start() {
        val inputPrice = LottoPurchaseView.inputPriceForPurchase()
        val lottoList = purchaseLotto(inputPrice)
        val winningLotto = WinningLottoView.inputWinningLotto()
        val lottoRanks = winningLotto.match(lottoList)
        StatisticsView.printResult(LottoMatchReport.of(lottoRanks))
    }

    private fun purchaseLotto(inputPrice: Long): List<Lotto> {
        return lottoSeller.purchaseAuto(inputPrice)
            .also { LottoPurchaseView.printPurchaseResult(it) }
    }
}
