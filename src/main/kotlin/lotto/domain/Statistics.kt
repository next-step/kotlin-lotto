package lotto.domain

data class Statistics(private val winningLotto: WinningLotto, private val lottos: List<Lotto>) {
    fun calculateLottoRank(): Map<LottoRank, Int> {
        val ranks = lottos.map { winningLotto.getUserRank(it) }
        return mapOf()
    }

    companion object {
        private const val NOT_PRIZED_RANK = 0
    }
}
