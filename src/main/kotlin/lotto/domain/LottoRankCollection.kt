package lotto.domain

class LottoRankCollection(val rankCount: Map<Rank, Int>) {
    val sumAmount: Int
        get() = rankCount.entries
            .sumBy { it.key.amount * it.value }
}
