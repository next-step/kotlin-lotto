package lotto.domain.maker

import lotto.domain.LotteryTicket

class DefaultLotteryTicketMaker : LotteryTicketMaker {

    override fun createLotteryTicket(): LotteryTicket {
        val numbers = (LotteryTicketMaker.LOTTERY_MIN_NUMBER..LotteryTicketMaker.LOTTERY_MAX_NUMBER).shuffled()
            .take(LotteryTicketMaker.LOTTERY_NUMBER_SIZE)
            .sorted()
        return LotteryTicket(numbers)
    }
}
