package lotto

data class LottoResultList(val resultList: List<LottoRank>) {
    fun count(rank: LottoRank) = resultList.count { it == rank }

    private val prizeMoney = run {
        var total = 0
        for (rank in LottoRank.values()) {
            total += count(rank) * rank.money
        }
        total
    }

    fun getProfitRate(buy: Int): Float {
        return prizeMoney / buy.toFloat()
    }
}
