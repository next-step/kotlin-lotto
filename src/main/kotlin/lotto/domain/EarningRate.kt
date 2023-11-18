package lotto.domain

@JvmInline
value class EarningRate(
    val value: Double,
) {
    fun isLoss(): Boolean = value < 1

    companion object {
        fun of(purchasedAmount: Int, earningAmount: Int): EarningRate {
            val earningRate = earningAmount.toDouble() / purchasedAmount
            return ((earningRate * 100).toInt() / 100.0).let(::EarningRate)
        }
    }
}
