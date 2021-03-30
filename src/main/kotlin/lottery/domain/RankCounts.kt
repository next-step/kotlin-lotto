package lottery.domain

class RankCounts(lottery: List<Lottery>, winnerLottery: WinnerLottery) {
    val rankCounts: Map<Rank, Int> =
        lottery.filter { Rank.isInTheRank(countMatchNumbers(winnerLottery, it), hasBonus(it, winnerLottery)) }
            .groupBy { Rank.valueOf(countMatchNumbers(winnerLottery, it), hasBonus(it, winnerLottery)) }
            .mapValues { it.value.count() }

    private fun hasBonus(it: Lottery, winnerLottery: WinnerLottery) = it.hasBonusBall(winnerLottery.bonusBall)

    private fun countMatchNumbers(winnerLottery: WinnerLottery, it: Lottery) =
        winnerLottery.matchCount(it.lotteryNumbers)

    fun retrieve(rank: Rank): Int {
        return rankCounts.getOrDefault(rank, DEFAULT_MATCH_COUNT)
    }

    fun calculateJackpots(): Int {
        return rankCounts.map { it.key.price * it.value }.sum()
    }

    companion object {
        const val DEFAULT_MATCH_COUNT = 0
    }
}
