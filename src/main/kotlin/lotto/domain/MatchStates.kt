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
    }
}
