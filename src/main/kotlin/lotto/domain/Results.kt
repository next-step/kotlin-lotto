package lotto.domain

data class Results(
    private val results: List<Result>,
) {
    val first: Int
        get() = results.count { it == Result.FIRST }

    val second: Int
        get() = results.count { it == Result.SECOND }

    val third: Int
        get() = results.count { it == Result.THIRD }

    val fourth: Int
        get() = results.count { it == Result.FOURTH }

    val miss: Int
        get() = results.count { it == Result.MISS }

    val prize: Money
        get() = Money(results.sumOf(Result::prize))
}
