package lotto.view

import lotto.domain.Lotto
import lotto.domain.Lottos
import lotto.domain.Statistics

object ResultView {

    fun showPurchaseCount(purchaseCount: Int) {
        println("$purchaseCount 개를 구입하였습니다.")
    }

    fun showPurchasedLottos(lottos: List<Lotto>) {
        lottos.map { println(it.numbers) }
    }

    fun showWinningResult(lottos: Lottos) {

        lottos.lottos.map { lotto ->
            lotto.winningCount == 3
        }
    }

    fun showWinningRank() {
        println("당첨 통계")
        println("---------")
        println("3개 일치 (5000원)- ${Statistics.count_3}개")
        println("4개 일치 (50000원)- ${Statistics.count_4}개")
        println("5개 일치 (1500000원)- ${Statistics.count_5}개")
        println("6개 일치 (2000000000원)- ${Statistics.count_6}개")
    }
}
