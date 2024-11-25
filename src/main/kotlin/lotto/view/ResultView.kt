package lotto.view

import lotto.domain.Lotto
import lotto.domain.WinningResult

object ResultView {
    fun printCreatedLottos(lottos: List<Lotto>) {
        println("${lottos.size}개를 구매했습니다.")
        lottos.forEach { println(it.numbers) }
        println()
    }

    fun printResult(result: WinningResult) {
        println("당첨 통계")
        println("-------")
        result.winningMatchCounts.forEach { data ->
            println("${data.prize.matchCount}개 일치 (${data.prize.prizeAmount}원) - ${data.totalCount}")
        }
        println("총 수익률은 ${result.rate}입니다.(기준이 1이기 때문에 결과적으로 손해라는 의미임)")
    }
}
