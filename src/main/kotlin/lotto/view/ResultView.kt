package lotto.view

import lotto.domain.Lotto
import lotto.domain.PrizeGenerator
import java.math.BigDecimal

object ResultView {

    fun showPurchasedLottos(purchaseCount: Int, lottos: List<Lotto>) {
        println("$purchaseCount 개를 구입하였습니다.")
        lottos.forEach { println(it.numbers) }
    }

    fun showWinningResult(map: MutableMap<PrizeGenerator, Int>) {
        println("당첨 통계")
        println("---------")

        PrizeGenerator.values()
            .filter { it != PrizeGenerator.ZERO_MATCH }
            .forEach {
                println("${it.name}개 일치 (${it.prize}원) - ${map[it] ?: 0}개")
            }
    }

    fun showRatio(calculateRatio: BigDecimal) {
        println("총 수익률은 ${calculateRatio}입니다.")
    }
}
