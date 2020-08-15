package lotto.view

import lotto.domain.LottoNumber
import lotto.domain.PrizeResult
import lotto.domain.result
import java.math.BigDecimal

object ResultView {
    fun showPurchasedLottos(purchaseCount: Int, tickets: List<Set<LottoNumber>>) {
        println("$purchaseCount 개를 구입하였습니다.")
        tickets.forEach { println(it) }
    }

    fun showWinningResult() {
        println("당첨 통계")
        println("---------")

        PrizeResult.values()
            .filter { it != PrizeResult.ZERO_MATCH }
            .forEach {
                println("${it.name}개 일치 (${it.prize}원) - ${result[it] ?: 0}개")
            }
    }

    fun showRatio(ratio: BigDecimal) {
        println("총 수익률은 ${ratio}입니다")
    }
}
