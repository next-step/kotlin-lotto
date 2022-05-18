package lotto.ui

import lotto.domain.LottoMatchResult
import lotto.domain.enums.LottoRank

object StatisticsView {
    fun printResult(lottoMatchResult: LottoMatchResult) {
        println("당첨 통계")
        println("---------")

        LottoRank.values()
            .filter { it != LottoRank.NONE }
            .sortedBy { it.matchingCount }
            .forEach {
                println("${it.matchingCount}개 일치 (${it.rewardPrice}원)- ${lottoMatchResult.matchingCountBy(it)}개")
            }

        println("총 수익률은 ${lottoMatchResult.rateOfReturn()}입니다.(기준이 1이기 때문에 결과적으로 손해라는 의미임)")
    }
}
