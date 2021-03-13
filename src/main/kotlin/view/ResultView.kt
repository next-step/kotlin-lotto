package view

import domain.Lotteries

object ResultView {
    private const val LOTTERY_NUMBER_DELIMITERS = ","

    fun printLotteries(lotteries: Lotteries) {
    }

    fun printLottery(LotteryNumbers: List<String>) {
        print("[ ${jointToLotteryNumbers(LotteryNumbers, LOTTERY_NUMBER_DELIMITERS)} ]")
    }

    private fun jointToLotteryNumbers(lotteryNumbers: List<String>, delimiter: String): String {
        return lotteryNumbers.joinToString("$delimiter ")
    }
}
