package lotto.domain.maker

import lotto.domain.LotteryTicket

interface LotteryTicketMaker {
    val lotteryTicketPrice
        get() = LOTTERY_TICKET_PRICE

    fun createLotteryTicket(): LotteryTicket

    companion object {
        const val LOTTERY_TICKET_PRICE = 1000
        const val LOTTERY_NUMBER_SIZE = 6
    }
}
