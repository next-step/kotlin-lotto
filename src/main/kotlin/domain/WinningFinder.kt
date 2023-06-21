package domain

class WinningFinder(
    private val winningNums: Set<Int>,
    private val bonusBall: Int,
) {

    fun getPrizeMoneyByMatched(lottery: Lottery): Int {
        val matchedCount = lottery.lotteryNumbers.intersect(winningNums).size
        val containBonusBall = lottery.lotteryNumbers.contains(bonusBall)
        return Prize.getPrizeMoneyByCount(matchedCount, containBonusBall)
    }
}
