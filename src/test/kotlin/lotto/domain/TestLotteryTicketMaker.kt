package lotto.domain

import lotto.domain.maker.LotteryTicketMaker

class TestLotteryTicketMaker : LotteryTicketMaker {
    override fun createLotteryTicket(): LotteryTicket {
        return LotteryTicket(listOf(1, 2, 3, 4, 5, 6))
    }
}