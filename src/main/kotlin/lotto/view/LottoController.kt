package lotto.view

import lotto.domain.analysis.LottoAnalysisRequest
import lotto.domain.analysis.LottoResultAnalyst
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

        val lastWeekWinLottoNumbers = lottoInputView.readLastWeekWinLottoNumbers()
        val lottoAnalysisRequest = LottoAnalysisRequest(
            lottoGames = lottoPurchaseResult.lottoGames,
            lottoPurchaseAmount = lottoPurchaseAmount,
            lastWeekWinLottoNumbers = lastWeekWinLottoNumbers,
        )
        val lottoAnalysisResult = lottoResultAnalyst.analyze(lottoAnalysisRequest)
    }
}
