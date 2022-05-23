package lotto

class Stat(private val lottos: List<Lotto>, private val checker: Checker) {
    fun matchResult(): List<Pair<List<Int>, MatchState?>> = lottos
        .map {
            it.numbers to MatchState.of(checker.match(it.numbers))
        }

    enum class MatchState(val matchCount: Int, val descriptor: String, val profit: Int) {
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
