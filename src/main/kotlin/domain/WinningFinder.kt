package domain

class WinningFinder(
    private val lottoDraw: LottoDraw,
) {
    fun getPrizeMoneyByMatched(lottery: Lottery): Int {
        val count = lottery.matchedCount(lottoDraw.winningNums)
        val containBonusBall = lottery.containBonusBall(lottoDraw.bonusBall)
        return Prize.getPrizeMoneyByCount(count, containBonusBall)
    }
}
