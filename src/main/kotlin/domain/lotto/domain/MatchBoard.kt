package domain.lotto.domain

enum class MatchBoard(val numberOfMatch: Int, val matchPrize: Int) {
    MISS(0, 0),
    FOURTH(3, 5_000),
    THIRD(4, 50_000),
    SECOND(5, 30_000_000),
    FIRST(6, 2_000_000_000);

    companion object {
        fun values(numberOfMatch: Int): MatchBoard =
            values().find { it.numberOfMatch == numberOfMatch } ?: MISS

        fun valuesExcludedMiss(): List<MatchBoard> = values().filterNot { it == MISS }
    }
}
