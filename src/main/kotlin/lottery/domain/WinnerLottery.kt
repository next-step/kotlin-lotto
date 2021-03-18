package lottery.domain

class WinnerLottery(numbers: List<Int>) {
    val lotteryNumbers: LotteryNumbers = LotteryNumbers(numbers)

    fun retrieveLotteryNumbers() = lotteryNumbers.numbers
}
