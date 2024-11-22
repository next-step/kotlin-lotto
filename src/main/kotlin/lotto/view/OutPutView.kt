package lotto.view

import lotto.domain.PurchasedLottos
import lotto.domain.Rank
import lotto.domain.WinningStatistics
import java.math.BigDecimal

class OutPutView {
    fun printLottoCount(count: Int) {
        println("${count}개를 구매했습니다.")
    }

    fun printPurchasedLottos(purchasedLottos: PurchasedLottos) {
        purchasedLottos
            .lottos
            .forEach { println(it.numbers) }
        println()
    }

    fun printStatistics(statistics: WinningStatistics) {
        println(formatStatistics(statistics))
    }

    private fun formatStatistics(statistics: WinningStatistics): String {
        val builder = StringBuilder()
        builder.append("당첨 통계\n---------\n")
        Rank.entries
            .filter { it != Rank.MISS } // MISS 제외
            .forEach { rank ->
                builder.append("${rank.matchCount}개 일치 (${rank.prize}원) - ${statistics.count(rank)}개\n")
            }
        return builder.toString()
    }

    fun printProfitRate(profitRate: BigDecimal) {
        println(
            "총 수익률은 %.2f입니다.${if (profitRate < BigDecimal.ONE) "(기준이 1이기 때문에 결과적으로 손해라는 의미임)" else ""}".format(
                profitRate,
            ),
        )
    }
}
