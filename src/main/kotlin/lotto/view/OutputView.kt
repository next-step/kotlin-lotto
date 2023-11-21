package lotto.view

import lotto.domain.Lotto
import lotto.domain.LottoCount
import lotto.domain.LottoPrize
import lotto.domain.LottoResult

object OutputView {
    fun printLottoResult(lottoResult: LottoResult) {
        println("당첨 통계")
        println("---------")
        LottoPrize.values().forEach {
            if (it == LottoPrize.MISS) return@forEach
            printPerPrize(it, lottoResult.getPrizeBy(it))
        }
        println("총 수익률은 ${lottoResult.calculateYield()}입니다.")
    }

    private fun printPerPrize(prize: LottoPrize, count: Int) {
        val matchCountMessage = "${prize.matchCount}개 일치"
        val hasBonusBallMessage = ", 보너스 볼 일치"
        val prizeMoneyMessage = "(${prize.prizeMoney}원) - ${count}개"

        println(
            buildString {
                append(matchCountMessage)
                if (prize == LottoPrize.SECOND) append(hasBonusBallMessage)
                append(prizeMoneyMessage)
            }
        )
    }

    fun buyLotto(lottos: List<Lotto>, lottoCount: LottoCount) {
        println("수동으로 ${lottoCount.manualLottoCount}장, 자동으로 ${lottoCount.autoLottoCount}개를 구매했습니다.")
        lottos.forEach { println(it.numbers) }
        println()
    }
}
