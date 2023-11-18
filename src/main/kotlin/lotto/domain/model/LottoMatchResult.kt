package lotto.domain.model

data class LottoMatchResult(
    private val cash: LottoCash,
    private val matchCountList: List<LottoMatchCount>
) {
    val three: Int
        get() = matchCountList.filter { it == LottoMatchCount.THREE }.size

    val four: Int
        get() = matchCountList.filter { it == LottoMatchCount.FOUR }.size

    val five: Int
        get() = matchCountList.filter { it == LottoMatchCount.FIVE }.size

    val six: Int
        get() = matchCountList.filter { it == LottoMatchCount.SIX }.size

    private val totalRewards: Int
        get() = matchCountList.sumOf { it.reward }

    val totalReturnRatio: Float
        get() = totalRewards / cash.value.toFloat()
}
