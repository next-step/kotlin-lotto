package lotto.domain

@JvmInline
value class EarningRate(
    val value: Double,
) {
    fun isLoss(): Boolean = value < 1

    companion object {
        fun of(purchasedAmount: Amount, earningAmount: Amount): EarningRate {
            val earningRate = earningAmount.toDouble() / purchasedAmount.value
            return ((earningRate * 100).toInt() / 100.0).let(::EarningRate)
        }
    }
}
