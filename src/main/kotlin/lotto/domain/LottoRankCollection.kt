package lotto.domain

class LottoRankCollection(private val rankCount: Map<Rank, Int>) {
    val sumAmount: Int
        get() = rankCount.entries
            .sumBy { it.key.amount * it.value }
}
