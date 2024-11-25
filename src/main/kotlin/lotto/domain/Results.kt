package lotto.domain

data class Results(
    private val results: List<Result>,
) {
    val prize: Money
        get() = results.sumOf(Result::prize)

    private fun List<Result>.sumOf(prize: (Result) -> Money): Money {
        return this.map(prize).reduce(Money::plus)
    }

    fun countByResult(result: Result): Int {
        fun count(result: Result): Int {
            return results.count { it == result }
        }

        return when (result) {
            Result.FIRST -> count(result)
            Result.SECOND -> count(result)
            Result.THIRD -> count(result)
            Result.FOURTH -> count(result)
            Result.FIFTH -> count(result)
            Result.MISS -> count(result)
        }
    }
}
