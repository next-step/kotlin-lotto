package lotto.view

import lotto.model.lotto.Lotto
import lotto.model.prize.Prize
import lotto.model.prize.Winners

object ResultView {
    fun showLottos(list: List<Lotto>) {
        println("${list.size}개 로또 구매완료")
        list.map { println(it) }
    }

    fun showWinners(winners: Winners) {
        println("당첨통계")
        Prize.values().forEach {
            println("${it.matchingCount}개 일치 (${it.prizeMoney}) - ${winners.getPrizeCount(it)}")
        }
        println("총 수익률 : ${winners.getTotalYield()}")
    }
}
