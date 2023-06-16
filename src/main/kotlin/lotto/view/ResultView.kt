package lotto.view

import lotto.controller.MatchResult
import lotto.controller.MatchResult.Companion.PRIZES
import lotto.domain.Lotto
import lotto.domain.Lotto.Companion.PER_LOTTO_PRICE

class ResultView {

    fun printLottoInfo(lotto: Lotto) {
        println("${lotto.lottoList.size}개를 구매했습니다.")
        lotto.lottoList.forEach {
            println(it.lottoNumbers)
        }
        println()
    }
    fun printStatistics(matchResult: MatchResult, count: Int) {
        println()
        println("당첨 통계")
        println("---------")

        for ((matches, prize) in PRIZES) {
            val numberOfMatches = matchResult.matches[matches] ?: 0
            println("${matches}개 일치 ($prize) - ${numberOfMatches}개")
        }
        val earningRate = matchResult.calculateEarningRate(count * PER_LOTTO_PRICE)
        val resultMessage = if (earningRate < 1) "(기준이 1이기 때문에 결과적으로 손해라는 의미임)" else "(이익)"
        println("총 수익률은 %.2f입니다. $resultMessage".format(earningRate))
    }
}
