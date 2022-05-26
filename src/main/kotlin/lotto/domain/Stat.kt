package lotto.domain

class Stat(private val lottos: List<Lotto>, private val checker: Checker) {
    val matchRecords: List<MatchState>
        get() = lottos.map { MatchState.of(checker.match(it.numbers)) }
    private val mergeRecords: List<StatResult>
        get() {
            return List(AVAILABLE_COUNT + 1) {
                StatResult(
                    matchState = MatchState.of(it + AVAILABLE_COUNT),
                    count = matchRecords.matchStateCount(it + AVAILABLE_COUNT),
                )
            }
        }
    val sumRecords: List<StatResult>
        get() = mergeRecords.map { it.copy(sum = it.matchState.profit * it.count) }

    private fun List<MatchState>.matchStateCount(matchCount: Int): Int {
        return this.filter { it.matchCount == matchCount }.size
    }

    companion object {
        const val AVAILABLE_COUNT = 3
    }
}

data class StatResult(val matchState: MatchState, val count: Int, val sum: Int = 0)
