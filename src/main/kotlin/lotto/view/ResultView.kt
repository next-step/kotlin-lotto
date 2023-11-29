package lotto.view

import lotto.domain.LottoResult
import lotto.domain.Rank
import lotto.domain.RankResult
import java.lang.StringBuilder

class ResultView {
    fun printRankResults(rankResult: RankResult) {
        println("당첨 통계")
        println("--------")
        Rank.values().forEach { rank ->
            val rankHitStringBuilder = StringBuilder()
                .append("${rank.hitCount}개 일치")
                .apply {
                    if (rank.needBonusHit) append(", 보너스볼 일치")
                }.append(" (${rank.prize}원)")
                .append(" - ${rankResult.getWinCount(rank)}개")
            println(rankHitStringBuilder)
        }
    }

    fun printResult(lottoResult: LottoResult) {
        println("총 수익은 ${lottoResult.totalPrize} 입니다.")
        println("총 수익률은 ${lottoResult.profitRate} 입니다.")
    }
}
