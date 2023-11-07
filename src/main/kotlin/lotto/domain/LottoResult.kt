package lotto.domain

class LottoResult(
    private val ranks: Map<LottoRank, Int>,
    private val rateCalculus: RateCalculus = DefaultRateCalculus()
) {

    fun getRateOfReturn(customer: Customer): Double {
        val amountSum = this.ranks.map { it.key.amount * it.value }.sumOf { it.toDouble() }
        return rateCalculus.calc(amountSum, customer.money.toDouble())
    }
    operator fun get(lottoWinning: LottoRank) = ranks[lottoWinning]
}
