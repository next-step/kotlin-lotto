package lotto.domain

data class LottoTicketWinningResult(
    val lottoPrize: LottoPrize,
    val winningLottoTicketCount: Int,
) {
    val totalWinningPrizeMoney: Long
        get() = lottoPrize.prizeMoney * winningLottoTicketCount
}
