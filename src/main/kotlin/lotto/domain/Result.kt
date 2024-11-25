package lotto.domain

enum class Result(
    private val predicateCount: (Int) -> Boolean,
    val count: Int,
    val prize: Int,
) {
    FIRST(
        predicateCount = { it == FIRST.count },
        count = 6,
        prize = 2_000_000_000,
    ),
    SECOND(
        predicateCount = { it == SECOND.count },
        count = 5,
        prize = 15_000_000,
    ),
    THIRD(
        predicateCount = { it == THIRD.count },
        count = 4,
        prize = 50_000,
    ),
    FOURTH(
        predicateCount = { it == FOURTH.count },
        count = 3,
        prize = 5_000,
    ),
    MISS(
        predicateCount = { it < FOURTH.count },
        count = 3,
        prize = 0,
    ),
    ;

    companion object {
        fun of(count: Int): Result =
            entries.firstOrNull { it.predicateCount(count) }
                ?: throw IllegalArgumentException()
    }
}
