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

    enum class MatchState(val matchCount: Int, val descriptor: String, val profit: Int) {
        MATCH_0(0, "", 0),
        MATCH_1(1, "", 0),
        MATCH_2(2, "", 0),
        MATCH_3(3, "3개 일치 (5000원)- %s개", 5_000),
        MATCH_4(4, "4개 일치 (50000원)- %s개", 50_000),
        MATCH_5(5, "5개 일치 (1500000)- %s개", 1_500_000),
        MATCH_6(6, "6개 일치 (2000000000)- %s개", 2_000_000_000),
        ;

        companion object {
            fun of(matchCount: Int): MatchState =
                values().first { it.matchCount == matchCount }
        }
    }
}

class StatResult(val matchState: Stat.MatchState, count: Int)
