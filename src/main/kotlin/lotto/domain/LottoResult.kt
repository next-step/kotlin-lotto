package lotto.domain

data class LottoResult(
    val totalTicketPrice: Int,
    val totalPrize: Long,
    val remainder: Int,
) {
    val profitRate: Double get() = String.format("%.2f", totalPrize.toDouble() / totalTicketPrice.toDouble()).toDouble()
}
