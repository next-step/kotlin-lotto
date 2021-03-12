package lotto.domain

import lotto.data.WinningNumbers
import lotto.domain.maker.DefaultLotteryTicketMaker
import lotto.domain.maker.LotteryTicketMaker

class Buyer {

    private val tickets: MutableList<LotteryTicket> = mutableListOf()

    fun buyLotteryTickets(
        payedPrice: Int,
        lotteryTicketMaker: LotteryTicketMaker = DefaultLotteryTicketMaker()
    ): List<LotteryTicket> {
        repeat(payedPrice / lotteryTicketMaker.lotteryTicketPrice) {
            tickets.add(lotteryTicketMaker.createLotteryTicket())
        }
        return tickets
    }

    fun createWinningStatics(winningNumbers: WinningNumbers): WinningStatistics {
        val winningStatistics = WinningStatistics()
        tickets.map { it.findWinningType(winningNumbers) }
            .forEach { winningStatistics.addTicketOf(it) }
        return winningStatistics
    }
}
