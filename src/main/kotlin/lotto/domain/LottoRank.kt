package lotto.domain

enum class LottoRank(val lottoMatchResult: LottoMatchResult, val winningMoney: Int) {
    FIRST(
        lottoMatchResult = LottoMatchResult(6),
        winningMoney = 2_000_000_000,
    ),
    SECOND(
        lottoMatchResult = LottoMatchResult(5),
        winningMoney = 1_500_000,
    ),
    THIRD(
        lottoMatchResult = LottoMatchResult(4),
        winningMoney = 50_000,
    ),
    FOURTH(
        lottoMatchResult = LottoMatchResult(3),
        winningMoney = 5_000,
    ),
    MISS(
        lottoMatchResult = LottoMatchResult(0),
        winningMoney = 0,
    ),
    ;

    companion object {
        private val LOTTO_RANK: Map<LottoMatchResult, LottoRank> = values().associateBy { it.lottoMatchResult }

        fun valueOf(lottoMatchResult: LottoMatchResult): LottoRank = LOTTO_RANK[lottoMatchResult] ?: MISS
    }
}
