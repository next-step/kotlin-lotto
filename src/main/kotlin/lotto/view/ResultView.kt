package lotto.view

import lotto.agency.LottoTicket
import lotto.agency.LottoWinning

class ResultView {

    fun printPurchaseAmount(amount: Int) {
        println("${amount}개를 구입했습니다.")
    }

    fun printPurchaseLottoTickets(lottoTickets: List<LottoTicket>) {
        lottoTickets.map {
            println(it.numbers)
        }
    }

    fun printWinningStatistics(winnings: Map<LottoWinning, Int>, money: Int) {
        printMatchedCount(winnings)
        printProfitRate(winnings, money)
    }

    private fun printMatchedCount(winnings: Map<LottoWinning, Int>) {
        winnings
            .filter { it.key != LottoWinning.LOSE }
            .map {
                println("${it.key.matchCount}개 일치 (${it.key.winningMoney}원) : ${it.value}개")
            }
    }

    private fun printProfitRate(winnings: Map<LottoWinning, Int>, money: Int) {
        val profitRate = winnings.map { it.key.winningMoney.times(it.value) }.sumOf { it.toDouble() } / money.toDouble()
        println("총 수익률은 " + String.format("%.2f", profitRate) + "입니다.")
    }
}
