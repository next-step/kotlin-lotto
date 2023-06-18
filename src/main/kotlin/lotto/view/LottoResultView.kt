package lotto.view

import lotto.domain.analysis.LottoAnalysisResult
import lotto.domain.shop.LottoPurchaseResult

interface LottoResultView {

    fun display(lottoPurchaseResult: LottoPurchaseResult)

    fun display(lottoAnalysisResult: LottoAnalysisResult)
}
