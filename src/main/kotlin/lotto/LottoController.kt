package lotto

import lotto.domain.Lotto
import lotto.domain.LottoMatchReport
import lotto.domain.LottoNumbers
import lotto.domain.LottoSeller
import lotto.ui.LottoPurchaseView
import lotto.ui.StatisticsView
import lotto.ui.WinningLottoView

class LottoController {

    private val lottoSeller = LottoSeller()

    fun start() {
        val inputPrice = LottoPurchaseView.inputPriceForPurchase()
        val inputManualLottoCount = LottoPurchaseView.inputManualLottoCount()
        val inputManualLottoNumbers = LottoPurchaseView.inputManualLottoNumbers(inputManualLottoCount)

        val lottoList = purchaseLotto(inputPrice, inputManualLottoNumbers)

        val winningLotto = WinningLottoView.inputWinningLotto()
        val lottoRanks = winningLotto.match(lottoList)
        StatisticsView.printResult(LottoMatchReport.of(lottoRanks))
    }

    private fun purchaseLotto(inputPrice: Long, inputManualLottoNumbers: List<LottoNumbers>): List<Lotto> {
        require(inputPrice >= inputManualLottoNumbers.size * LottoSeller.LOTTO_PRICE) {
            "수동으로 구매할 로또 금액이 총 구입급액을 초과합니다."
        }
        return lottoSeller.purchase(inputPrice, inputManualLottoNumbers)
            .also { LottoPurchaseView.printPurchaseResult(it) }
    }
}
