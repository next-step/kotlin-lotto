package lottery.ui

import lottery.domain.lotto.Lotto
import lottery.domain.ranking.Ranking
import lottery.domain.winningresult.WinningResult

class ResultView {
    fun showPurchasingResult(lottos: List<Lotto>) {
        println("${lottos.size}개를 구매했습니다.")
        showIssuedLottos(lottos)
    }

    private fun showIssuedLottos(lottos: List<Lotto>) {
        lottos.forEach {
            println(it.numbers)
        }
        println("\n")
    }

    fun showResultOfWinning(winningResult: WinningResult) {
        val resultByRank = Ranking.values().map {
            "${it.rank}개 일치 (${it.prize}원) - ${winningResult[it.rank]}개"
        }.joinToString("\n")

        val statistics = buildString {
            append("당첨 통계\n")
            append("---------\n")
            append(resultByRank)
        }

        println(statistics)
    }

    fun showRateOfReturn(rateOfReturn: String) {
        val totalRateOfReturnMessage = "총 수익률은 ${rateOfReturn}입니다."
        println(totalRateOfReturnMessage)
    }
}
