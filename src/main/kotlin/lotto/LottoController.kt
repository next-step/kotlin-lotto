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
        val inputManualLottoCount = LottoPurchaseView.inputManualLottoCount()
        val lottoList = purchaseLotto(inputPrice, inputManualLottoCount)
        val winningLotto = WinningLottoView.inputWinningLotto()
        val lottoRanks = winningLotto.match(lottoList)
        StatisticsView.printResult(LottoMatchReport.of(lottoRanks))
    }

    private fun purchaseLotto(inputPrice: Long, inputManualLottoCount: Int): List<Lotto> {
        require(inputPrice >= inputManualLottoCount * LottoSeller.LOTTO_PRICE) {
            "수동으로 구매할 로또 금액이 총 구입급액을 초과합니다."
        }
        val inputManualLottoNumbers = LottoPurchaseView.inputManualLottoNumbers(inputManualLottoCount)
        return lottoSeller.purchase(inputPrice, inputManualLottoNumbers)
            .also { LottoPurchaseView.printPurchaseResult(it) }
    }
}
