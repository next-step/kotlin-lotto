package lotto.view

import lotto.domain.LottoStatistics
import lotto.domain.LottoTicket
import lotto.domain.PrizeResult
import java.math.BigDecimal

object ResultView {
    fun showPurchasedLottos(purchaseCount: Int, tickets: List<LottoTicket>) {
        println("$purchaseCount 개를 구입하였습니다.")
        tickets.forEach { println(it) }
    }

    fun showWinningResult(resultPrizeList: LottoStatistics) {
        println("당첨 통계")
        println("---------")

        PrizeResult.values()
            .filter { it != PrizeResult.MISS }
            .forEach {
                println(
                    "${it.matchCount}개 일치" + "${if (it.hasBonus) ", 보너스 볼 일치" else ""} (${it.prize}원) - ${resultPrizeList.result[it]
                        ?: 0}개"
                )
            }
    }

    fun showRatio(ratio: BigDecimal) {
        println("총 수익률은 ${ratio}입니다")
    }
}
