package lotto.view

import lotto.controller.MatchResult
import lotto.domain.LottoNumber
import lotto.domain.Lottos
import lotto.domain.Prize

class ResultView {

    fun printLottoInfo(lottos: Lottos) {
        println("${lottos.getSize()}개를 구매했습니다.")
        lottos.lottoList.forEach {
            println(formatLottoNumbers(it.lottoNumbers))
        }
        println()
    }
    private fun formatLottoNumbers(lottoNumbers: List<LottoNumber>): String {
        return lottoNumbers.joinToString(", ") { lottoNumber -> lottoNumber.value.toString() }.let { "[$it]" }
    }

    fun printStatistics(matchResult: MatchResult, money: Int) {
        println()
        println("당첨 통계")
        println("---------")

        for (prize in Prize.values()) {
            val statisticsLine = printStatistics(prize, matchResult.getNumberOfMatchesForPrize(prize))
            if (statisticsLine.isNotEmpty()) {
                println(statisticsLine)
            }
        }

        val isProfit = matchResult.isProfit(money)
        val earningRate = matchResult.calculateEarningRate(money)
        val resultMessage = if (isProfit) "(이익)" else "(기준이 1이기 때문에 결과적으로 손해라는 의미임)"
        println("총 수익률은 %.2f입니다. $resultMessage".format(earningRate))
    }

    private fun printStatistics(prize: Prize, numberOfMatches: Int): String {
        return when (prize) {
            Prize.SECOND -> "5개 일치, 보너스 볼 일치 (${prize.amount}원) - ${numberOfMatches}개"
            Prize.NO_PRIZE -> ""
            else -> "${prize.matchCount}개 일치 (${prize.amount}원) - ${numberOfMatches}개"
        }
    }
}
