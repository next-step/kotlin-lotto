package lotto.domain

class LottoGameResult(
    purchaseMoney: Long,
    winningLottoNumbers: LottoNumbers,
    lottoTickets: List<LottoTicket>,
) {
    val lottoTicketWinningInfos: List<LottoTicketWinningInfo>
    val totalRateOfReturn: Double

    init {
        lottoTicketWinningInfos = LottoPrize.values().map { lottoPrize ->
            val winningLottoTicketCount = lottoTickets.filter { it.countMatchingLottoNumbers(winningLottoNumbers) == lottoPrize.matchCount }.size
            LottoTicketWinningInfo(lottoPrize, winningLottoTicketCount)
        }

        val totalLottoPrizeMoney = lottoTicketWinningInfos
            .sumOf { it.totalWinningPrizeMoney }
        totalRateOfReturn = totalLottoPrizeMoney.toDouble() / purchaseMoney.toDouble()
    }
}
