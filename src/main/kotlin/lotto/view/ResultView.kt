package lotto.view

import lotto.domain.LottoStatistics
import lotto.domain.Order
import lotto.domain.Rank
import lotto.domain.WinningResult

object ResultView {
    fun printCreatedLottos(
        order: Order,
        manualLottoCount: Int,
    ) {
        println("수동으로 $manualLottoCount 개, 자동으로 ${order.lottos.size - manualLottoCount} 개를 구매했습니다.")
        order.lottos.forEach { println(it.numbers) }
        println()
    }

    fun printResult(result: WinningResult) {
        println("당첨 통계")
        println("-------")
        result.winningMatchCounts.forEach { data ->
            printLottoResult(data)
        }
        println("총 수익률은 ${result.rate}입니다.(기준이 1이기 때문에 결과적으로 손해라는 의미임)")
    }

    private fun printLottoResult(statistic: LottoStatistics) {
        if (statistic.rank == Rank.SECOND) {
            println("${statistic.rank.expectedMatchCount}개 일치, 보너스 볼 일치 (${statistic.rank.prizeAmount}원) - ${statistic.lottoMatchCount}")
        } else {
            println("${statistic.rank.expectedMatchCount}개 일치 (${statistic.rank.prizeAmount}원) - ${statistic.lottoMatchCount}")
        }
    }
}
