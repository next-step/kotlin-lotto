package lotto.view

import lotto.domain.LottoCollection
import lotto.domain.LottoWonNumber
import lotto.domain.Rank

class ResultView(private val lottoCollection: LottoCollection) {
    fun printLotto() {
        lottoCollection.lotto.forEach { println(it) }
    }

    fun printWon(wonNumber: LottoWonNumber) {
        val matchByWonNumber = lottoCollection.matchByWonNumber(wonNumber)
        val wonRank = Rank.getWonRank()

        wonRank.forEach {
            println("${it.count}개 일치 (${it.amount}원)- ${matchByWonNumber.rankCount[it] ?: 0}")
        }
    }

    fun printRate(wonNumber: LottoWonNumber) {
        val matchByWonNumber = lottoCollection.matchByWonNumber(wonNumber)
        val rate: Double = (matchByWonNumber.sumAmount.toDouble() / (lottoCollection.lotto.size * 1000).toDouble())

        print("총 수익률은 ${"%.2f".format(rate)}입니다.(기준이 1이기 때문에 결과적으로 손해라는 의미임)")
    }
}
