package lotto.view

import lotto.model.Lotto
import lotto.model.Rank
import lotto.model.toDecimalPoint

object ResultView {
    fun showBuyLotto(lottoList: List<Lotto>) {
        println("${lottoList.size}개를 구매했습니다.")
        lottoList.forEach {
            println(it.numbers.map { lottoNumber -> lottoNumber.number })
        }
    }

    fun showWinningList(result: Map<Rank, Int>) {
        println("당첨 통계\n-----------")
        Rank.values().forEach {
            val count = result[it] ?: 0
            val bonus = if(it == Rank.SECOND) ", 보너스 볼" else ""
            println("${it.count}개 일치 $bonus (${it.reward}원) - $count 개")
        }
    }

    fun showTotalStatistics(total: Double) {
        println("총 수익률은 ${total.toDecimalPoint()} 입니다..")
    }
}
