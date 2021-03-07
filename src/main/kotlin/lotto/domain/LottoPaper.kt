package lotto.domain

internal class LottoPaper(private val values: List<Lotto>) {
    fun result(money: Money, winLotto: Lotto): LottoStatistics {
        val rankCounts: HashMap<Rank, Int> = hashMapOf<Rank, Int>()
        this.values.forEach {
            val matchedNums = it.findMatchedNums(winLotto)
            val rank = Rank.find(matchedNums.size)
            val count = rankCounts.getOrDefault(rank, 0)
            rankCounts[rank] = count + 1
        }

        return LottoStatistics(money, rankCounts)
    }
}
