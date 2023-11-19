package lotto.view

import lotto.domain.model.Lotto
import lotto.domain.model.LottoMatchResult
import lotto.domain.model.Rank

object ResultView {
    fun printPurchaseResult(lottos: List<Lotto>) {
        println("${lottos.size}개를 구매했습니다.")
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
        return "${matchCount}개 일치 (${reward}원)- ${count(this)}개"
    }
}
