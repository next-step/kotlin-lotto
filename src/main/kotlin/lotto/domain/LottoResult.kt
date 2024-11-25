package lotto.domain

data class LottoResult(
    private val results: Results,
    val incomeRate: IncomeRate,
) {
    val first: Int
        get() = results.countByResult(Result.FIRST)

    val second: Int
        get() = results.countByResult(Result.SECOND)

    val third: Int
        get() = results.countByResult(Result.THIRD)

    val fourth: Int
        get() = results.countByResult(Result.FOURTH)

    val fifth: Int
        get() = results.countByResult(Result.FIFTH)

    val miss: Int
        get() = results.countByResult(Result.MISS)

    val totalWinningCount: Int
        get() = first + second + third + fourth

    val prize: Money
        get() = results.prize

    val incomeRateValue: Double
        get() = incomeRate.value
}
