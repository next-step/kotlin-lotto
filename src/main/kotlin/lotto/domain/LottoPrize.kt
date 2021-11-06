package lotto.domain

interface LottoPrize {
    fun isMatchPrize(matchResult: MatchResult): Boolean
}
