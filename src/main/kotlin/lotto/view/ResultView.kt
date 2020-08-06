package lotto.view

import lotto.domain.Lotto
import lotto.domain.Lottos
import lotto.domain.PrizeGenerator
import java.math.BigDecimal

object ResultView {

    fun showPurchasedLottos(purchaseCount: Int, lottos: List<Lotto>) {
        println("$purchaseCount 개를 구입하였습니다.")
        lottos.forEach { println(it.numbers) }
    }

    fun showWinningResult(lottos: Lottos) {
        println("당첨 통계")
        println("---------")
        println("3개 일치 (5000원)- ${PrizeGenerator.THREE_MATCH.count}개")
        println("4개 일치 (50000원)- ${PrizeGenerator.FOUR_MATCH.count}개")
        println("5개 일치 (1500000원)- ${PrizeGenerator.FIVE_MATCH.count}개")
        println("6개 일치 (2000000000원)- ${PrizeGenerator.SIX_MATCH.count}개")
    }

    fun showRatio(calculateRatio: BigDecimal) {
        println("총 수익률은 ${calculateRatio}입니다.")
    }
}
