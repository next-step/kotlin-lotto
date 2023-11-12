package lotto.domain

class LottoWinningReceipt(
    private val ranks: Map<LottoRank, Int>,
    private val rateCalculus: RateCalculus = DefaultRateCalculus()
) {

    fun getRateOfReturn(purchase: LottoPurchase): Double {
        val amountSum = this.ranks.map { it.key.winningMoney * it.value }.sumOf { it.toDouble() }
        val purchaseMoney = purchase.money.toDouble()
        return rateCalculus.calc(amountSum, purchaseMoney)
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
