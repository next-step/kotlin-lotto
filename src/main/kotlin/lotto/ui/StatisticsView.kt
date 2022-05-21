package lotto.ui

import lotto.domain.LottoMatchReport
import lotto.domain.enums.LottoRank

object StatisticsView {
    fun printResult(lottoMatchReport: LottoMatchReport) {
        println("당첨 통계")
        println("---------")

        LottoRank.values()
            .reversed()
            .filter { it != LottoRank.NONE }
            .forEach {
                rank ->
                when (rank) {
                    LottoRank.SECOND -> println("${rank.matchingCount}개 일치, 보너스 볼 일치 (${rank.rewardPrice}원)- ${lottoMatchReport.matchingCountBy(rank)}개")
                    else -> println("${rank.matchingCount}개 일치 (${rank.rewardPrice}원)- ${lottoMatchReport.matchingCountBy(rank)}개")
                }
            }
        println("총 수익률은 ${lottoMatchReport.rateOfReturn}입니다.(기준이 1이기 때문에 결과적으로 손해라는 의미임)")
    }
}
