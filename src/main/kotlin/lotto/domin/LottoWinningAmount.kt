package lotto.domin

enum class LottoWinningAmount(
    val title: String,
    val matchCount: Int,
    val bonusMatchCount: Int?,
    val winningAmount: Long,
) {
    FOURTH("3개 일치", 3, null, 5_000),
    THIRD("4개 일치", 4, null, 50_000),
    SECOND("5개 일치", 5, 0, 1_500_000),
    SECOND_BONUS("5개 일치, 보너스 볼 일치", 5, 1, 30_000_000),
    FIRST("6개 일치", 6, null, 2_000_000_000);

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
