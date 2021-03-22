package lotto.view

import lotto.domain.LottoTickets
import lotto.domain.LottoWonNumbers
import lotto.domain.Rank

class ResultView(private val lottoTickets: LottoTickets) {
    fun printLotto() {
        lottoTickets.forEach { println(it) }
    }

    fun printWon(wonNumbers: LottoWonNumbers) {
        val matchByWonNumber = wonNumbers.match(lottoTickets)
        val wonRank = Rank.getWonRank()

        wonRank.forEach {
            println("${it.matchCondition} (${it.amount}원)- ${matchByWonNumber.rankCount[it] ?: 0}")
        }
    }

    fun printRate(wonNumbers: LottoWonNumbers) {
        val matchByWonNumber = wonNumbers.match(lottoTickets)
        val rate: Double = (matchByWonNumber.sumAmount.toDouble() / (lottoTickets.size * 1000).toDouble())

        print("총 수익률은 ${"%.2f".format(rate)}입니다.(기준이 1이기 때문에 결과적으로 손해라는 의미임)")
    }
}
