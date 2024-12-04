package lotto.domain

data class Statistics(private val winningLotto: WinningLotto, private val lottos: List<Lotto>) {
    fun groupByLottoRank(): List<LottoRankWithCount> {
        return lottos.groupBy { winningLotto.getUserRank(it) }.map { LottoRankWithCount(it.key, it.value.size) }
            .filter { it.rank != NOT_PRIZED_RANK }.sortedByDescending { it.rank }
    }

    companion object {
        private const val NOT_PRIZED_RANK = 0
    }
}
