package lotto.domain

import java.util.EnumMap

class LottoResult(private val result: EnumMap<LottoPrize, Int>) {
    constructor(resultMap: Map<LottoPrize, Int>) : this(EnumMap(resultMap))

    fun getResult(prize: LottoPrize) = result[prize]

    fun getProfitRate(money: Money): Double {
        val sum = result.map { it.key.prizeMoney * it.value }.sum()
        return sum.toDouble() / money.amount
    }
}
