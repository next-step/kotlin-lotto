package lotto.domain

enum class Result(
    private val predicateResult: (Int, Boolean) -> Boolean,
    val count: Int,
    val prize: Money,
) {
    FIRST(
        predicateResult = { count, _ -> count == FIRST.count },
        count = 6,
        prize = Money(2_000_000_000),
    ),
    SECOND(
        predicateResult = { count, isBonus -> count == SECOND.count && isBonus },
        count = 5,
        prize = Money(30_000_000),
    ),
    THIRD(
        predicateResult = { count, isBonus -> count == THIRD.count && !isBonus },
        count = 5,
        prize = Money(1_500_000),
    ),
    FOURTH(
        predicateResult = { count, _ -> count == FOURTH.count },
        count = 4,
        prize = Money(50_000),
    ),
    FIFTH(
        predicateResult = { count, _ -> count == FIFTH.count },
        count = 3,
        prize = Money(5_000),
    ),
    MISS(
        predicateResult = { count, _ -> count < MISS.count },
        count = 3,
        prize = Money(0),
    ),
    ;

    companion object {
        private const val MAX_COUNT = 6

        fun of(
            count: Int,
            matchBonus: Boolean = false,
        ): Result {
            require(count <= MAX_COUNT) { "로또 번호는 6개를 초과할 수 없습니다." }
            return entries.first { it.predicateResult(count, matchBonus) }
        }
    }
}
