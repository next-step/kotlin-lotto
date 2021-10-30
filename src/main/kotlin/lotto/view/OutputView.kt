package lotto.view

import lotto.domain.Lotto
import lotto.domain.LottoStatistics

class OutputView {

    fun printLotto(lottos: List<Lotto>) {
        println("${lottos.size}개를 구매했습니다.")

        lottos.forEach { lotto ->
            println(lotto)
        }
    }

    fun printStatistics(statistics: LottoStatistics) {
        println("3개 일치 (5000원) - ${statistics.fourthRank}")
        println("4개 일치 (50000원) - ${statistics.thirdRank}")
        println("5개 일치 (1500000) - ${statistics.secondRank}")
        println("6개 일치 (2000000000원) - ${statistics.firstRank}")
        println("총 수익률은 ${statistics.getYield()}")
    }
}
