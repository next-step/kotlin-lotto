package lotto.domain

import java.util.EnumMap

data class LottoResult(
    private val results: Results,
    val incomeRate: IncomeRate,
) {
    val prize: Money
        get() = results.prize

    val incomeRateValue: Double
        get() = incomeRate.value

    val ranks: EnumMap<Result, Int>
        get() {
            val resultCountMap = Result.entries.associateWith(results::countByResult)
            return EnumMap(resultCountMap)
        }
}
