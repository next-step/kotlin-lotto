package lotto.domain

import lotto.data.WinningNumbers
import lotto.domain.maker.DefaultLotteryTicketMaker
import lotto.domain.maker.LotteryTicketMaker
import lotto.enums.LotteryMatchType

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
            val matchCount = it.findMatchCount(winningNumbers)
            val lotteryMatchType = LotteryMatchType.findByMatchCount(matchCount)
            winningStatistics.addTicketCountOf(lotteryMatchType)
        }
        return winningStatistics
    }
}