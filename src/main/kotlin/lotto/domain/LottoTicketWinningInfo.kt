package lotto.domain

data class LottoTicketWinningInfo(
    val lottoPrize: LottoPrize,
    val winningLottoTicketCount: Int,
) {
    val totalWinningPrizeMoney: Long
        get() = lottoPrize.prizeMoney * winningLottoTicketCount
}
