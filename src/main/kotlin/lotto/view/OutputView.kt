package lotto.view

import lotto.domain.Lotto
import lotto.domain.LottoStatistics
import lotto.domain.Rank

class OutputView {

    fun printLotto(lottos: List<Lotto>) {
        println("${lottos.size}개를 구매했습니다.")

        lottos.forEach { lotto ->
            println(lotto)
        }
    }

    fun printStatistics(statistics: LottoStatistics) {
        println("3개 일치 (5000원) - ${statistics.getCountByRank(Rank.FIFTH)}")
        println("4개 일치 (50000원) - ${statistics.getCountByRank(Rank.FOURTH)}")
        println("5개 일치 (1500000원) - ${statistics.getCountByRank(Rank.THIRD)}")
        println("5개 일치, 보너스 볼 일치(30000000원) - ${statistics.getCountByRank(Rank.SECOND)}")
        println("6개 일치 (2000000000원) - ${statistics.getCountByRank(Rank.FIRST)}")
        println("총 수익률은 ${statistics.getYield()}")
    }
}
