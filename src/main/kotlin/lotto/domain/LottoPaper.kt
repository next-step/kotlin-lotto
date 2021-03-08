package lotto.domain

internal data class LottoPaper(val lottos: List<Lotto>) {

    fun doStatistics(money: Money, winLotto: Lotto): LottoStatistics {
        val rankCounts: HashMap<Rank, Int> = hashMapOf()
        this.lottos.forEach {
            val matchedNums = it.findMatchedNums(winLotto)
            val rank = Rank.find(matchedNums.size)
            val count = rankCounts.getOrDefault(rank, 0)
            rankCounts[rank] = count + 1
        }

        return LottoStatistics(money, rankCounts)
    }
}
