package lotto.domain

data class LottoResult(
    val matchedNumberCount: Int,
    val ticketCount: Int,
) {
    fun getPrizeAmount(prizesInfo: List<WinningPrize>): Amount {
        val prizeInfo = prizesInfo.firstOrNull() { it.matchedCount == matchedNumberCount } ?: return Amount(0)
        return prizeInfo.amount * ticketCount
    }
}
