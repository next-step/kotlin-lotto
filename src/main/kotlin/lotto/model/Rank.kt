package lotto.model

enum class Rank(val matchCount: Int, val prize: Int) {
    FIRST(6, 2_000_000_000),
    SECOND(5, 1_500_000),
    THIRD(4, 50_000),
    FOURTH(3, 5000),
    ;

    companion object {
        fun of(matchCount: Int): Rank? =
            values().find { it.matchCount == matchCount }
    }
}
