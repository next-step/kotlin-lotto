package lotto.domain.model

data class LottoMatchResult(
    private val cash: LottoCash,
    private val rankList: List<Rank>
) {
    fun count(rank: Rank): Int {
        return rankList.filter { it == rank }.size
    }

    private val totalRewards: Int
        get() = rankList.sumOf { it.reward }

    val totalReturnRatio: Float
        get() = totalRewards / cash.value.toFloat()
}
