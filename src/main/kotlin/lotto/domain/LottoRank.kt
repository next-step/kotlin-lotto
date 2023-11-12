package lotto.domain

enum class LottoRank(
    val countOfMatch: Int,
    val winningMoney: Int
) {

    FIRST(6, 2_000_000_000),
    SECOND(5, 30_000_000),
    THIRD(5, 1_500_000),
    FOURTH(4, 50_000),
    FIFTH(3, 5_000),
    MISS(0, 0)
    ;

    companion object {
        private fun <WIN, RANK> compose(bonus: (WIN) -> RANK, normal: (WIN) -> RANK): (WIN) -> RANK =
            { winningResult: WIN ->
                when (val rank = bonus(winningResult)) {
                    MISS -> normal(winningResult)
                    else -> rank
                } 
            }

        private fun getBonusRank(lottoWinningResult: LottoWinningResult) =
            if (lottoWinningResult.countOfMatch == SECOND.countOfMatch && lottoWinningResult.isBonusRank) SECOND
            else MISS
        private fun getNormalRank(lottoWinningResult: LottoWinningResult) =
            entries.filter { it != SECOND }
                .find { it.countOfMatch == lottoWinningResult.countOfMatch } ?: MISS

        fun valueOf(lottoWinningResult: LottoWinningResult): LottoRank =
            compose(::getBonusRank, ::getNormalRank)(lottoWinningResult)
    }
}
