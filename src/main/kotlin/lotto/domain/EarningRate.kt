package lotto.domain

data class EarningRate(
    val rate: Double,
) {
    fun isLoss(): Boolean = rate < 1

    companion object {
        fun of(purchasedAmount: Amount, earningAmount: Amount): EarningRate {
            val earningRate = earningAmount.toDouble() / purchasedAmount.value
            return ((earningRate * 100).toInt() / 100.0).let(::EarningRate)
        }
    }
}
