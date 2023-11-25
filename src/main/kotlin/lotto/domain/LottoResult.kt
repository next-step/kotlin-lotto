package lotto.domain

class LottoResult {
    private var result = LottoPrize.values().associateWith { 0 }.toMap()

    constructor(resultMap: Map<LottoPrize, Int>) {
        this.result = resultMap
    }

    fun getResult(prize: LottoPrize) = result[prize]

    fun getProfitRate(money: Money): Double {
        val sum = result.map { it.key.prizeMoney * it.value }.sum()
        return sum.toDouble() / money.amount
    }
}
