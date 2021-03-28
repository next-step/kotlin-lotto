package lottery.domain

class WinnerLottery(numbers: List<Int>, val bonusBall: BonusBall) {
    init {
        require(numbers.isNotContains(bonusBall)) { "보너스 볼은 당첨 번호에 포함될 수 없습니다." }
    }

    val winnerLottery: LotteryNumbers = LotteryNumbers(numbers)

    fun contains(bonusBall: Int): Boolean {
        return winnerLottery.contains(bonusBall)
    }

    fun matchCount(lotteryNumbers: LotteryNumbers): Int {
        return lotteryNumbers.filter { winnerLottery.contains(it) }.count()
    }

    private fun List<Int>.isNotContains(bonusBall: BonusBall): Boolean {
        return !this.contains(bonusBall.number)
    }
}
