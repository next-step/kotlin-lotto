package lotto.ui

import lotto.entity.Rank
import lotto.entity.Wallet
import lotto.entity.WinningInfo

class ResultView {
    fun showLottoTickets(wallet: Wallet, numberOfManualTicket: Int) {
        val tickets = wallet.tickets
        println("수동으로 $numberOfManualTicket 장, 자동으로 ${tickets.size - numberOfManualTicket}개를 구매했습니다.")
        tickets.forEach { ticket ->
            println(
                ticket.numbers
            )
        }
        println()
    }

    fun showMatchResult(money: Int, winnings: WinningInfo) {
        println("\n당첨 통계")
        println("---------")
        var sum = 0
        winnings.countOfRanks.onEach { it ->
            when (it.key) {
                Rank.SECOND -> println("${it.key.countOfMatch}개 일치, 보너스 볼 일치 (${it.key.winningMoney}원) - ${it.value}개")
                else -> println("${it.key.countOfMatch}개 일치 (${it.key.winningMoney}원) - ${it.value}개")
            }
            sum += it.value * it.key.winningMoney
        }
        println(String.format("총 수익률은 %.2f 입니다.", sum.toDouble() / money))
    }
}
