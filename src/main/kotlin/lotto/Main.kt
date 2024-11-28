package lotto

import lotto.domain.LottoResult
import lotto.view.InputView
import lotto.view.LottoView

fun main() {
    val purchasePrice = InputView.drawAndGetPurchasePrice()
    val selectLottoCount = InputView.drawAndGetSelectLottoCount()
    val lottoCustomerInput = InputView.drawAndGetLottoCustomerInput(purchasePrice, selectLottoCount)
    val winningNumbers = InputView.drawAndGetWinningNumbers()
    val lottoResult = LottoResult.getLottoResult(lottoCustomerInput, winningNumbers)

    LottoView.drawLottos(lottoResult.lottos)
    LottoView.drawMatchMap(lottoResult.lottoOutcome.lottoRankMatchMap)
    LottoView.drawProfitRate(lottoResult.lottoOutcome.lottoProfitRate)
}
