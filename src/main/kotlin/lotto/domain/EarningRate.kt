package lotto.domain

data class EarningRate(
    val rate: Double,
) {
    fun isLoss(): Boolean = rate < 1
}
