package lotto.view

import lotto.domain.analysis.LottoAnalysisResult
import lotto.domain.analysis.LottoWinRankAnalysisResult
import lotto.domain.analysis.Revenue
import lotto.domain.lottonumber.unWrapping
import lotto.domain.shop.LottoPurchaseResult

class RealLottoResultView : LottoResultView {

    override fun display(lottoPurchaseResult: LottoPurchaseResult) {
        println(lottoPurchaseResult.makePurchaseSizeDisplayText())
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
        println(lottoWinRankAnalysisResult.makeDisplayText())
    }

    private fun LottoPurchaseResult.makePurchaseSizeDisplayText(): String {
        return buildString {
            if (selfSettingCount.value > 0) {
                append("수동으로 ${selfSettingCount.value}장, ")
            }
            append("자동으로 ${autoSettingCount.value}개를 구매했습니다.")
        }
    }

    private fun LottoWinRankAnalysisResult.makeDisplayText(): String {
        return buildString {
            append("${numberMatchCount.value}개 일치")
            if (isBonusMatched) {
                append(", 보너스 볼 일치")
            }
            append("(${rankWinAmount.value}원)- ${ranksCount.value}개")
        }
    }

    private fun display(revenue: Revenue) {
        println("총 수익률은 ${revenue.rateOfReturn}입니다.")
    }
}
