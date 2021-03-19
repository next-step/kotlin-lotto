package lottery.domain

class WinnerLottery(numbers: List<Int>) {
    val winnerLottery: LotteryNumbers = LotteryNumbers(numbers)

    fun contains(bonusBall: Int): Boolean {
        return winnerLottery.contains(bonusBall)
    }

    fun matchCount(lotteryNumbers: LotteryNumbers): Int {
        return lotteryNumbers.filter { winnerLottery.contains(it) }.count()
    }
}
