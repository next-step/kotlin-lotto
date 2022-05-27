package lotto.domain

enum class MatchState(val matchCount: Int, val profit: Int) {
    NOT_MATCH(0, 0),
    MATCH_3(3, 5_000),
    MATCH_4(4, 50_000),
    MATCH_5(5, 1_500_000),
    MATCH_6(6, 2_000_000_000),
    ;

    companion object {
        fun of(matchCount: Int): MatchState = runCatching {
            values().first { it.matchCount == matchCount }
        }.getOrDefault(NOT_MATCH)
    }
}
