package lotto.view

import lotto.domain.analysis.LottoAnalysisResult
import lotto.domain.analysis.LottoWinRankAnalysisResult
import lotto.domain.analysis.Revenue
import lotto.domain.lottonumber.unWrapping
import lotto.domain.shop.LottoPurchaseResult

class RealLottoResultView : LottoResultView {

    override fun display(lottoPurchaseResult: LottoPurchaseResult) {
        println("${lottoPurchaseResult.lottoGames.size}개를 구매했습니다.")
        lottoPurchaseResult.lottoGames
            .map { lottoGame -> lottoGame.lottoNumbers.value }
            .forEach { lottoNumbers -> println("[${lottoNumbers.unWrapping().joinToString(", ")}]") }
    }

    override fun display(lottoAnalysisResult: LottoAnalysisResult) {
        println("당첨 통계")
        println("---------")
        lottoAnalysisResult.lottoWinRankAnalysisResults.forEach(::display)
        display(lottoAnalysisResult.revenue)
    }

    override fun newLine() {
        println()
    }

    private fun display(lottoWinRankAnalysisResult: LottoWinRankAnalysisResult) {
        lottoWinRankAnalysisResult.run {
            println("${numberMatchCount.value}개 일치 (${rankWinAmount.value}원)- ${ranksCount.value}개")
        }
    }

    private fun display(revenue: Revenue) {
        println("총 수익률은 ${revenue.rateOfReturn}입니다.")
    }
}
