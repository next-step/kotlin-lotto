package lotto

data class LottoResult(
    val results: Results,
    val incomeRate: IncomeRate,
) {
    val first: Int
        get() = results.first

    val second: Int
        get() = results.second

    val third: Int
        get() = results.third

    val fourth: Int
        get() = results.fourth

    val miss: Int
        get() = results.miss

    val totalWinningCount: Int
        get() = first + second + third + fourth

    val prize: Money
        get() = results.prize

    val incomeRateValue: Double
        get() = incomeRate.value
}
