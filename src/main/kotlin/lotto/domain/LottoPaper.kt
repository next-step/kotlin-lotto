package lotto.domain

internal data class LottoPaper(val lottos: List<Lotto>) {

    fun doStatistics(money: Money, winLotto: Lotto, bonusNum: LottoNum): LottoStatistics {
        val rankCounts: HashMap<Rank, Int> = hashMapOf()
        this.lottos.forEach {
            val matchedNums = it.findMatchedNums(winLotto)
            val rank = Rank.find(matchedNums.size, it.contain(bonusNum))
            val count = rankCounts.getOrDefault(rank, EMPTY_COUNT)
            rankCounts[rank] = count + 1
        }

        return LottoStatistics(money, rankCounts)
    }

    companion object {
        private const val EMPTY_COUNT = 0
    }
}
