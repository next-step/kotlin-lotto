package domain

class WinningChecker(
    private val winningNums: Set<Int>,
    private val bonusBall: Int,
) {
    fun checkLotteries(
        lotteries: List<Lottery>,
    ): MutableMap<Prize, Int> {
        val prizeCountMap = mutableMapOf<Prize, Int>()

        lotteries.forEach { lottery ->
            val prize = lottery.calculatePrize(winningNums, bonusBall) ?: return@forEach
            prizeCountMap[prize] = (prizeCountMap[prize] ?: 0) + 1
        }

        return prizeCountMap
    }
}
