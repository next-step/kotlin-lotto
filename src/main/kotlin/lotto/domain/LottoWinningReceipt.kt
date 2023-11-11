package lotto.domain

class LottoWinningReceipt(
    private val ranks: Map<LottoRank, Int>,
    private val rateCalculus: RateCalculus = DefaultRateCalculus()
) {

    fun getRateOfReturn(customer: Customer): Double {
        val amountSum = this.ranks.map { it.key.amount * it.value }.sumOf { it.toDouble() }
        return rateCalculus.calc(amountSum, customer.money.toDouble())
    }
    operator fun get(lottoWinning: LottoRank) = ranks[lottoWinning]
    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }
        if (javaClass != other?.javaClass) {
            return false
        }

        other as LottoWinningReceipt

        return ranks == other.ranks
    }

    override fun hashCode(): Int {
        return ranks.hashCode()
    }
}
