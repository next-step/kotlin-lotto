package lottery

class LotteryRank {
    var lotteriesRank: List<LotteryPrize> = LotteryPrize.values().toList()

    fun plusRank(rank: LotteryPrize) = ++lotteriesRank.find { it == rank }!!.count
    fun calculateProfit(money: Int): Double {
        var total = 0.0
        lotteriesRank.forEach {
            total += it.rewardMoney * it.count
        }
        return total / money
    }
}
