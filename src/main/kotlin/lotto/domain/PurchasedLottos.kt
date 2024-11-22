package lotto.domain

@JvmInline
value class PurchasedLottos(val lottos: List<Lotto>) {
    fun calculateRanks(winningLotto: WinningLotto): Map<Rank, MatchedCount> {
        return lottos.map { winningLotto.getRank(it) }
            .groupingBy { it }
            .eachCount()
    }
}
