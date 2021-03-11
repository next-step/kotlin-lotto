package lotto.domain

import lotto.data.LottoNumbers
import lotto.domain.maker.DefaultLotteryTicketMaker
import lotto.domain.maker.LotteryTicketMaker
import lotto.enums.LotteryMatchType

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

    fun createWinningStatics(winningNumbers: LottoNumbers): WinningStatistics {
        val winningStatistics = WinningStatistics()
        tickets.map { it.findMatchCount(winningNumbers) }
            .forEach { winningStatistics.addTicketOf(LotteryMatchType.findByMatchCount(it)) }
        return winningStatistics
    }
}
