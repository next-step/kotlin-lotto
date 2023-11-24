package lotto.domain

class LottoResult {
    private val result = LottoPrize.values().associateWith { 0 }.toMutableMap()

    fun getResult(prize: LottoPrize) = result[prize]

    fun updateResult(prize: LottoPrize) {
        result.computeIfPresent(prize) { _, cnt -> cnt + 1 }
    }


    fun getProfitRate(money: Money): Double {
        val sum = result.map { it.key.prizeMoney * it.value }.sum()
        return sum.toDouble() / money.amount
    }
}
