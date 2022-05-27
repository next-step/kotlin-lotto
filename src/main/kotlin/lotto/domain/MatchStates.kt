package lotto.domain

class MatchStates(private val matchStates: List<MatchState>) {
    fun accumulate(): List<StatResult> {
        return matchStates
            .filterNot { it == MatchState.NOT_MATCH }
            .groupBy { it.matchCount }
            .map {
                val matchState = it.value.first()
                val count = it.value.size
                val sum = matchState.profit * count
                StatResult(matchState = matchState, count = count, sum = sum)
            }
            .union(defaultMatchStates)
            .distinctBy { it.matchState }
            .sortedBy { it.matchState }
    }
    companion object {
        private val defaultMatchStates = listOf(
            StatResult(MatchState.MATCH_3),
            StatResult(MatchState.MATCH_4),
            StatResult(MatchState.MATCH_5),
            StatResult(MatchState.MATCH_6),
        )
    }
}
