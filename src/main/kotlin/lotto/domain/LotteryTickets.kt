package lotto.domain

import lotto.data.WinningNumbers
import lotto.domain.maker.DefaultLotteryTicketMaker
import lotto.domain.maker.LotteryTicketMaker

class LotteryTickets(ticketNum: Int, private val lotteryTicketMaker: LotteryTicketMaker = DefaultLotteryTicketMaker()) {

    val lotteryTickets = mutableListOf<LotteryTicket>()

    init {
        repeat(ticketNum) {
            val lotteryTicket = lotteryTicketMaker.createLotteryTicket()
            lotteryTickets.add(lotteryTicket)
        }
    }

    fun createWinningStatics(winningNumbers: WinningNumbers): WinningStatistics {
        val winningStatistics = WinningStatistics()
        lotteryTickets.forEach {
            val matchNumber = it.findMatchNumber(winningNumbers)
            winningStatistics.addMatchNumberCount(matchNumber)
        }
        return winningStatistics
    }
}