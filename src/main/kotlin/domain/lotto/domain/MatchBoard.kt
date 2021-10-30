package domain.lotto.domain

enum class MatchBoard(private val numberOfMatch: Int, private val matchPrize: Int) {
    FIRST(6, 2_000_000_000),
    SECOND(5, 30_000_000),
    THIRD(5, 1_500_000),
    FOURTH(4, 50_000),
    FIFTH(3, 5_000),
    MISS(0, 0);

    companion object {
        fun values(numberOfMatch: Int): MatchBoard =
            values().asSequence()
                .find { it.numberOfMatch == numberOfMatch }
                ?: MISS
    }
}