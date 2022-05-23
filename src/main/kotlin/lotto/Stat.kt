package lotto

class Stat(private val lottos: List<Lotto>, private val checker: Checker) {
    fun matchResult(): List<MatchState> = lottos
        .map { MatchState.of(checker.match(it.numbers)) }

    fun sumResult(record: List<MatchState>): List<StatResult> {
        return List(AVAILABLE_COUNT + 1) {
            StatResult(
                matchState = MatchState.of(it + AVAILABLE_COUNT),
                count = record.matchStateCount(it + AVAILABLE_COUNT)
            )
        }
    }

    private fun List<MatchState>.matchStateCount(matchCount: Int): Int {
        return this.filter { it.matchCount == matchCount }.size
    }

    companion object {
        const val AVAILABLE_COUNT = 3
    }
}

class StatResult(val matchState: MatchState, count: Int)
