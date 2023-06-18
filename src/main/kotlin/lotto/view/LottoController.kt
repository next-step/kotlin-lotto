package lotto.view

import lotto.domain.analysis.LottoAnalysisRequest
import lotto.domain.shop.LottoShop

class LottoController(
    private val lottoInputView: LottoInputView,
    private val lottoResultView: LottoResultView,
    private val lottoShop: LottoShop,
    private val lottoResultAnalyst: LottoResultAnalyst,
) {

    fun start() {
        val lottoPurchaseAmount = lottoInputView.readLottoPurchaseAmount()
        val lottoPurchaseResult = lottoShop.purchase(lottoPurchaseAmount)
        lottoResultView.display(lottoPurchaseResult)

        lottoResultView.newLine()

        val lastWeekWinLottoNumbers = lottoInputView.readLastWeekWinLottoNumbers()
        val lottoAnalysisRequest = LottoAnalysisRequest(
            lottoGames = lottoPurchaseResult.lottoGames,
            lottoPurchaseAmount = lottoPurchaseAmount,
            lastWeekWinLottoNumbers = lastWeekWinLottoNumbers,
        )

        lottoResultView.newLine()

        val lottoAnalysisResult = lottoResultAnalyst.analyze(lottoAnalysisRequest)
        lottoResultView.display(lottoAnalysisResult)
    }
}
