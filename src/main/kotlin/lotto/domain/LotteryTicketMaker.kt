package lotto.domain

object LotteryTicketMaker {

    private const val LOTTERY_NUMBER_SIZE = 6
    private const val ZERO_INDEX = 0
    private const val LOTTERY_MIN_NUMBER = 1
    private const val LOTTERY_MAX_NUMBER = 45

    fun createLotteryTicket(): LotteryTicket {
        val numbers = (LOTTERY_MIN_NUMBER..LOTTERY_MAX_NUMBER).shuffled().subList(ZERO_INDEX, LOTTERY_NUMBER_SIZE).sorted()
        return LotteryTicket(numbers)
    }
}
