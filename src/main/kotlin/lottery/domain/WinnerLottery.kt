package lottery.domain

class WinnerLottery(numbers: List<Int>) {
    val winnerLottery: LotteryNumbers = LotteryNumbers(numbers)

    fun matchCount(lotteryNumbers: LotteryNumbers): Int {
        return lotteryNumbers.filter { winnerLottery.contains(it) }.count()
    }
}
