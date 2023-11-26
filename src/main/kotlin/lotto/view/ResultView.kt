package lotto.view

import lotto.domain.model.Lotto
import lotto.domain.model.LottoMatchResult
import lotto.domain.model.Rank

object ResultView {
    fun printPurchaseResult(lottosByManualCount: Int, lottosByAutoCount: Int, lottos: List<Lotto>) {
        println("수동으로 ${lottosByManualCount}개, 자동으로 ${lottosByAutoCount}개를 구매했습니다.")
        lottos.forEach { lotto ->
            println(lotto.map { it.value })
        }
        println()
    }

    fun printLottoMatchResult(lottoMatchResult: LottoMatchResult, rankList: List<Rank>) {
        println()
        println("당첨 통계")
        println("---------")
        rankList.forEach { rank ->
            println(rank.toResultWith { lottoMatchResult.count(it) })
        }
        println("총 수익률은 %.2f입니다.".format(lottoMatchResult.totalReturnRatio))
    }

    private fun Rank.toResultWith(count: (Rank) -> Int): String {
        return if (this == Rank.SECOND) {
            "${matchCount}개 일치, 보너스 볼 일치(${reward}원)- ${count(this)}개"
        } else {
            "${matchCount}개 일치 (${reward}원)- ${count(this)}개"
        }
    }
}
