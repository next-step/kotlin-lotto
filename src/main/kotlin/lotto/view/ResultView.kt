package lotto.view

import lotto.agency.LottoTicket
import lotto.agency.LottoWinning

class ResultView {

    fun printPurchaseAmount(amount: Int) {
        println("${amount}개를 구입했습니다.")
    }

    fun printPurchaseLottoTickets(lottoTickets: List<LottoTicket>) {
        lottoTickets.map { lottoTicket ->
            println(lottoTicket.numbers.map { it.number })
        }
    }

    fun printWinningStatistics(winnings: Map<LottoWinning, Int>, money: Int) {
        printMatchedCount(winnings)
        printProfitRate(winnings, money)
    }

    private fun printMatchedCount(winnings: Map<LottoWinning, Int>) {
        winnings
            .filter { it.key != LottoWinning.LOSE }
            .map { println(getLottoWinningSentence(it)) }
    }

    private fun getLottoWinningSentence(winnings: Map.Entry<LottoWinning, Int>): String {
        return if (winnings.key == LottoWinning.SECOND_PLACE) {
            "${winnings.key.matchCount}개 일치, 보너스 볼 일치 (${winnings.key.winningMoney}원) : ${winnings.value}개"
        } else {
            "${winnings.key.matchCount}개 일치 (${winnings.key.winningMoney}원) : ${winnings.value}개"
        }
    }

    private fun printProfitRate(winnings: Map<LottoWinning, Int>, money: Int) {
        val profitRate = winnings.map { it.key.winningMoney.times(it.value) }.sumOf { it.toDouble() } / money.toDouble()
        println("총 수익률은 " + String.format("%.2f", profitRate) + "입니다.")
    }
}
