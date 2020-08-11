package view

import model.Lotto
import model.LottoStat
import model.Rank

object ResultView {
    fun printLottoList(list: List<Lotto>) {
        list.forEach {
            print(it)
            println()
        }
        println()
    }

    fun printLottoStat(list: List<LottoStat>) {
        list.filter { it.getGrade() > Rank.MISS.grade }
            .forEach { print("${it.getGrade()}개 일치 (${it.getSumPrizeMoney()}) - ${it.count} 개\n") }
        println()
    }

    fun printEarningRate(earningRate: Double) {
        println("총 수익률은 " + String.format("%.2f", earningRate) + "입니다.(기준이 1이기 때문에 결과적으로 손해라는 의미임)")
    }
}
