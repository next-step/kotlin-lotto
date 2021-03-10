package lotto.domain

import lotto.domain.maker.LotteryTicketMaker

class Buyer {

    private val tickets: MutableList<LotteryTicket> = mutableListOf()

    fun buyLotteryTickets(payedPrice: Int, lotteryTicketMaker: LotteryTicketMaker): List<LotteryTicket> {
        repeat(payedPrice / lotteryTicketMaker.lotteryTicketPrice) {
            tickets.add(lotteryTicketMaker.createLotteryTicket())
        }
        return tickets
    }
}
