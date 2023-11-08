package lotto.domain

data class LottoResult(
    val matchedNumberCount: Int,
    val ticketCount: Int,
) {
    fun calculatePrize(prizesInfo: List<WinningPrize> = LottoSpec.prizesInfo): Amount {
        val prizeInfo = prizesInfo.firstOrNull { it.matchedCount == matchedNumberCount } ?: return Amount(0)
        return prizeInfo.amount * ticketCount
    }
}
