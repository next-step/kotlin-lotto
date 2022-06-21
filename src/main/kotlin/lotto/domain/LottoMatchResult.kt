package lotto.domain

@JvmInline
value class EarnedRate(val rate: Float) {
    init {
        require(rate >= 0.0f) { "수익률은 항상 0이상이에요. given rate: $rate" }
    }
}

@JvmInline
value class Count(val count: Int)

data class LottoMatchResult(
    val matchResult: MatchResult,
    val earnedMoney: EarnedMoney,
)

data class MatchResult(
    val matchResult: Map<Rank, Count>
) {
    fun getResult() = matchResult.filter { it.key != Rank.MISS }
}
