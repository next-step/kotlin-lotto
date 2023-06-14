package lotto.domain

enum class LottoRank(val lottoMatchResult: LottoMatchResult, val winningMoney: Int) {
    FIRST(
        lottoMatchResult = LottoMatchResult(countOfMatch = 6),
        winningMoney = 2_000_000_000,
    ),
    SECOND(
        lottoMatchResult = LottoMatchResult(countOfMatch = 5, MatchState.MATCH),
        winningMoney = 30_000_000,
    ),
    THIRD(
        lottoMatchResult = LottoMatchResult(countOfMatch = 5, MatchState.NON_MATCH),
        winningMoney = 1_500_000,
    ),
    FOUR(
        lottoMatchResult = LottoMatchResult(countOfMatch = 4),
        winningMoney = 50_000,
    ),
    FIVE(
        lottoMatchResult = LottoMatchResult(countOfMatch = 3),
        winningMoney = 5_000,
    ),
    MISS(
        lottoMatchResult = LottoMatchResult(countOfMatch = 0),
        winningMoney = 0,
    ),
    ;

    companion object {
        fun valueOf(lottoMatchResult: LottoMatchResult): LottoRank = values().find {
            it.lottoMatchResult.correctMatchResult(otherMatchResult = lottoMatchResult)
        } ?: MISS
    }
}
