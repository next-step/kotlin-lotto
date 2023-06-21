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
        val lottoPurchasePaper = lottoInputView.readLottoPurchaseInfo()
        val lottoPurchaseResult = lottoShop.purchase(lottoPurchasePaper)
        lottoResultView.display(lottoPurchaseResult)

        lottoResultView.newLine()

        val lastWeekWinLottoNumbers = lottoInputView.readLastWeekWinLottoNumbers()
        val lottoAnalysisRequest = LottoAnalysisRequest(
            lottoGames = lottoPurchaseResult.lottoGames,
            lottoPurchaseAmount = lottoPurchasePaper.lottoPurchaseAmount,
            lastWeekWinLottoNumbers = lastWeekWinLottoNumbers,
        )

        lottoResultView.newLine()

        val lottoAnalysisResult = lottoResultAnalyst.analyze(lottoAnalysisRequest)
        lottoResultView.display(lottoAnalysisResult)
    }
}
