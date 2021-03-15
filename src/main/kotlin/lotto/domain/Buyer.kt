package lotto.domain

import lotto.data.BuyingData
import lotto.data.WinningNumbers
import lotto.domain.maker.DefaultLotteryTicketMaker
import lotto.domain.maker.LotteryTicketMaker

class Buyer {

    private val tickets: MutableList<LotteryTicket> = mutableListOf()

    fun buyLotteryTickets(
        buyingData: BuyingData,
        lotteryTicketMaker: LotteryTicketMaker = DefaultLotteryTicketMaker()
    ): List<LotteryTicket> {
        var ticketCount = buyingData.inputPrice / lotteryTicketMaker.lotteryTicketPrice

        for (lottoNumbers in buyingData.manualNumbersList) {
            tickets.add(lotteryTicketMaker.createManualLotteryTicket(lottoNumbers))
        }

        repeat(ticketCount - buyingData.manualTicketCount) {
            tickets.add(lotteryTicketMaker.createAutoLotteryTicket())
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
