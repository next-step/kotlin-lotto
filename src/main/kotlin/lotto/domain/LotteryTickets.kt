package lotto.domain

import lotto.domain.maker.DefaultLotteryTicketMaker
import lotto.domain.maker.LotteryTicketMaker

class LotteryTickets(ticketNum: Int, private val lotteryTicketMaker: LotteryTicketMaker = DefaultLotteryTicketMaker()) {

    val lotteryTickets = mutableListOf<LotteryTicket>()

    init {
        repeat(ticketNum) {
            lotteryTickets.add(lotteryTicketMaker.createLotteryTicket())
        }
    }
}