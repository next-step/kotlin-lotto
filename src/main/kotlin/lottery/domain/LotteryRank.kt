package lottery.domain

class LotteryRank {
    val lotteriesRank = LotteryPrize.values().associateWith { 0 }.toMutableMap()

    fun plusRank(rank: LotteryPrize) {
        lotteriesRank[rank] = lotteriesRank.getOrDefault(rank, 0) + 1
    }

    fun calculateProfit(money: Int): Double {
        val total = lotteriesRank.map { (prize, count) ->
            prize.rewardMoney * count
        }.sumOf { it }.toDouble()
        return total / money
    }
}
