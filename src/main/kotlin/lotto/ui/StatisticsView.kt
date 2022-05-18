package lotto.ui

import lotto.domain.LottoMatchResult
import lotto.domain.LottoSeller.Companion.rewardPriceMap

object StatisticsView {
    fun printResult(lottoMatchResult: LottoMatchResult) {
        println("당첨 통계")
        println("---------")

        rewardPriceMap
            .entries
            .sortedBy { it.key }
            .forEach {
                (matchingCount, price) ->
                println("${matchingCount}개 일치 (${price}원)- ${lottoMatchResult.matchingCountBy(matchingCount)}개")
            }

        println("총 수익률은 ${lottoMatchResult.rateOfReturn()}입니다.(기준이 1이기 때문에 결과적으로 손해라는 의미임)")
    }
}
