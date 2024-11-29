package lotto

enum class Rank(val matchCount: Int, val prize: Int) {
    FIRST(6, 2_000_000_000),
    SECOND(5, 1_500_000),
    THIRD(4, 50_000),
    FOURTH(3, 5_000),
    NONE(0, 0),
    ;

    companion object {
        fun from(matchCount: Int): Rank {
            return entries.find { it.matchCount == matchCount } ?: NONE
        }
    }
}
