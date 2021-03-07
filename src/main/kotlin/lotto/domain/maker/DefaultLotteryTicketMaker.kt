package lotto.domain.maker

import lotto.domain.LotteryTicket

class DefaultLotteryTicketMaker : LotteryTicketMaker {

    override fun createLotteryTicket(): LotteryTicket {
        val numbers = (LotteryTicketMaker.LOTTERY_MIN_NUMBER..LotteryTicketMaker.LOTTERY_MAX_NUMBER).shuffled()
            .subList(LotteryTicketMaker.ZERO_INDEX, LotteryTicketMaker.LOTTERY_NUMBER_SIZE)
            .sorted()
        return LotteryTicket(numbers)
    }
}
