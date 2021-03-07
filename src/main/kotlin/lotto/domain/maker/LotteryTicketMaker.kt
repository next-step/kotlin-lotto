package lotto.domain.maker

import lotto.domain.LotteryTicket

interface LotteryTicketMaker {
    fun createLotteryTicket(): LotteryTicket

    companion object {
        const val LOTTERY_NUMBER_SIZE = 6
        const val ZERO_INDEX = 0
        const val LOTTERY_MIN_NUMBER = 1
        const val LOTTERY_MAX_NUMBER = 45
    }
}