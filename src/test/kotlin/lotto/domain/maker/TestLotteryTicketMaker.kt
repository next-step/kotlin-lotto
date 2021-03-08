package lotto.domain.maker

import lotto.domain.LotteryTicket

class TestLotteryTicketMaker : LotteryTicketMaker {
    override fun createLotteryTicket(): LotteryTicket {
        return LotteryTicket(listOf(1, 2, 3, 4, 5, 6))
    }
}