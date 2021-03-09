package lotto.domain

import lotto.constant.LOTTERY_TICKET_PRICE
import lotto.data.LotteryTicketNumber
import lotto.data.WinningNumbers
import lotto.domain.maker.DefaultLotteryTicketMaker
import lotto.domain.maker.LotteryTicketMaker
import lotto.enums.LotteryMatchType

class LotteryTickets(
    inputPrice: Int,
    lotteryTicketMaker: LotteryTicketMaker = DefaultLotteryTicketMaker()
) {

    val lotteryTickets = mutableListOf<LotteryTicket>()

    init {
        repeat(inputPrice / LOTTERY_TICKET_PRICE) {
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

    fun makeLotteryTicketNumberList(): List<LotteryTicketNumber> {
        return lotteryTickets.map { LotteryTicketNumber.from(it) }
    }
}