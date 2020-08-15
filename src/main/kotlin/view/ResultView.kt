package view

import model.Lotto
import model.LottoStat
import model.Rank

object ResultView {
    fun printLottoInfo(manual: Int, auto: Int) {
        println("수동으로 ${manual}장, 자동으로 ${auto}개를 구매했습니다.")
    }
    fun printLottoList(list: List<Lotto>) {
        list.forEach {
            print(it)
            println()
        }
        println()
    }

    fun printLottoStat(list: List<LottoStat>) {
        list.filter { it.isOverGrade(Rank.MISS.grade) }
            .forEach { print("${it.grade()}개 일치 (${it.sumPrizeMoney()}) - ${it.count} 개\n") }
        println()
    }

    fun printEarningRate(earningRate: Double) {
        println("총 수익률은 " + String.format("%.2f", earningRate) + "입니다.(기준이 1이기 때문에 결과적으로 손해라는 의미임)")
    }
}
