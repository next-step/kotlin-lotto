package lotto.dto

data class LottoMatchResult(
    val matchCounts: Map<Int, Int>,
    val bonusMatchCount: Int
) {
    fun getMatchCount(match: Int): Int = matchCounts.getOrDefault(match, 0)
}
