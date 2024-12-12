package lotto.view

import lotto.domain.Lotto
import lotto.domain.Rank
import java.math.BigDecimal

object ResultView {
    fun printTotalPurchaseCount(count: Int) {
        println("\n$count 개를 구매 했습니다.")
    }

    fun printLottoNumbers(list: List<Lotto>) {
        list.forEach { println(it) }
    }

    fun printLottoResult(resultMap: Map<Rank, Int>) {
        println("\n당첨 통계\n---------")
        Rank.getRanksFromLowest().forEach { rank ->
            if (rank == Rank.SECOND) {
                println("${rank.matchingNumberCount}개 일치, 보너스볼 일치(${rank.prizeMoney}원) - ${resultMap[rank]}")
            } else {
                println("${rank.matchingNumberCount}개 일치 (${rank.prizeMoney}원) - ${resultMap[rank]}")
            }
        }
    }

    fun printProfitRate(profitRate: BigDecimal) {
        println("\n총 수익률은 $profitRate 입니다.\n")
    }
}
