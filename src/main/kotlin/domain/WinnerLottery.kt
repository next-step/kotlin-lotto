package domain

class WinnerLottery(numbers: List<Int>) {
    val numbers: LotteryNumbers = LotteryNumbers(numbers)

    fun matchCount(lotteryNumbers: LotteryNumbers): Int {
        return lotteryNumbers.numbers.filter { this.numbers.numbers.contains(it) }.count()
    }
}
