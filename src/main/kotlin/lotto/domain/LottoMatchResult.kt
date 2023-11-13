package lotto.domain

data class LottoMatchResult(
    private val cash: LottoCash,
    private val matchList: List<LottoMatchCount>
) {
    val three: Int
        get() = matchList.filter { it == LottoMatchCount.THREE }.size

    val four: Int
        get() = matchList.filter { it == LottoMatchCount.FOUR }.size

    val five: Int
        get() = matchList.filter { it == LottoMatchCount.FIVE }.size

    val six: Int
        get() = matchList.filter { it == LottoMatchCount.SIX }.size

    private val totalRewards: Int
        get() = matchList.sumOf { it.reward }

    val totalReturnRatio: Float
        get() = totalRewards / cash.value.toFloat()
}
