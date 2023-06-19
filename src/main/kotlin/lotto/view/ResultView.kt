package lotto.view

import lotto.model.Lotto
import lotto.model.LottoPrize
import lotto.model.toDecimalPoint

object ResultView {
    fun showBuyLotto(lottoList: List<Lotto>) {
        println("${lottoList.size}개를 구매했습니다.")
        lottoList.forEach {
            println(it.numbers.map { lottoNumber -> lottoNumber.number })
        }
    }

    fun showWinningList(result: Map<LottoPrize, Int>) {
        println("당첨 통계\n-----------")
        LottoPrize.values().forEach {
            val count = result[it] ?: 0
            println("${it.count}개 일치 (${it.prize}원) - $count 개")
        }
    }

    fun showTotalStatistics(total: Double) {
        println("총 수익률은 ${total.toDecimalPoint()} 입니다..")
    }
}
