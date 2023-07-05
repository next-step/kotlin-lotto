package lottery.domain

class LotteryRank {
    val lotteriesRank = LotteryPrize.values().associateWith { RANK_DEFAULT_VALUE }.toMutableMap()

    fun plusRank(rank: LotteryPrize) {
        lotteriesRank[rank] = lotteriesRank.getOrDefault(rank, 0) + 1
    }

    fun calculateProfit(money: Int): Double {
        val total = lotteriesRank.map { (prize, count) ->
            prize.rewardMoney * count
        }.sumOf { it }.toDouble()
        return total / money
    }

    companion object {
        const val RANK_DEFAULT_VALUE = 0
    }
}
