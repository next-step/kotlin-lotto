package lotto.domain

enum class LottoRank(
    val countOfMatch: Int,
    val winningMoney: Int,
    val findRank: (LottoRank, LottoWinningResult) -> Boolean = isMatchRank
) {

    FIRST(6, 2_000_000_000),
    SECOND(5, 30_000_000 , isBonusRank),
    THIRD(5, 1_500_000),
    FOURTH(4, 50_000),
    FIFTH(3, 5_000),
    MISS(0, 0)
    ;

    companion object {
        fun valueOf(lottoWinningResult: LottoWinningResult): LottoRank =
            entries.find { it.findRank(it, lottoWinningResult) } ?: MISS
    }
}

private val isBonusRank: (LottoRank, LottoWinningResult) -> Boolean = { lottoRank, lottoWinningResult ->
    lottoRank == LottoRank.SECOND && lottoRank.countOfMatch == lottoWinningResult.countOfMatch && lottoWinningResult.isBonusRank
}

private val isMatchRank: (LottoRank, LottoWinningResult) -> Boolean = { lottoRank, lottoWinningResult ->
    lottoRank.countOfMatch == lottoWinningResult.countOfMatch
}
