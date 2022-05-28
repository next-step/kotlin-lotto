package lotto.domin

enum class LottoWinningAmount(
    val matchCount: Int,
    val bonusMatchCount: Int?,
    val winningAmount: Long,
) {
    FIFTH(3, null, 5_000),
    FOURTH(4, null, 50_000),
    THIRD(5, 0, 1_500_000),
    SECOND(5, 1, 30_000_000),
    FIRST(6, null, 2_000_000_000);

    companion object {
        fun matchWinningLotto(containCount: List<MatchCount>): Map<LottoWinningAmount, Int> = values()
            .associateWith { lottoWinningAmount ->
                containCount.count {
                    if (lottoWinningAmount.bonusMatchCount != null) {
                        it.matchCount == lottoWinningAmount.matchCount && it.bonusMatchCount == lottoWinningAmount.bonusMatchCount
                    } else {
                        it.matchCount == lottoWinningAmount.matchCount
                    }
                }
            }
    }
}
