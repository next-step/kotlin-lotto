package lotto.domain

enum class Result(
    private val predicate: (Int) -> Boolean,
    val count: Int,
    val prize: Int,
) {
    FIRST(
        predicate = { it == FIRST.count },
        count = 6,
        prize = 2_000_000_000,
    ),
    SECOND(
        predicate = { it == SECOND.count },
        count = 5,
        prize = 15_000_000,
    ),
    THIRD(
        predicate = { it == THIRD.count },
        count = 4,
        prize = 50_000,
    ),
    FOURTH(
        predicate = { it == FOURTH.count },
        count = 3,
        prize = 5_000,
    ),
    MISS(
        predicate = { it < FOURTH.count },
        count = 3,
        prize = 0,
    ),
    ;

    companion object {
        fun of(count: Int): Result =
            entries.firstOrNull { it.predicate(count) }
                ?: throw IllegalArgumentException()
    }
}
