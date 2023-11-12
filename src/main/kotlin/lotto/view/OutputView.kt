package lotto.view

import lotto.domain.Lotto
import lotto.domain.LottoPrize
import lotto.domain.LottoResult

object OutputView {
    fun printLottoResult(lottoResult: LottoResult) {
        println("당첨 통계")
        println("---------")
        lottoResult.prizeCount.forEach { (prize, count) ->
            if (prize == LottoPrize.MISS) return@forEach
            printPerPrize(prize, count)
        }
        println("총 수익률은 ${lottoResult.calculateYield()}입니다.")
    }

    private fun printPerPrize(prize: LottoPrize, count: Int) {
        println(
            buildString {
                append("${prize.matchCount}개 일치")
                if (prize == LottoPrize.SECOND) append(", 보너스 볼 일치")
                append(" (${prize.prizeMoney}원) - ${count}개")
            }
        )
    }

    fun buyLotto(lottos: List<Lotto>) {
        println("${lottos.size}개를 구매했습니다.")
        lottos.forEach { println(it.numbers) }
        println()
    }
}
