package lotto.domain

class LottoGameResult(
    purchaseMoney: Long,
    winningLottoNumbers: LottoNumbers,
    lottoTickets: List<LottoTicket>,
) {
    val lottoTicketWinningResults: List<LottoTicketWinningResult>
    val totalRateOfReturn: Double

    init {
        lottoTicketWinningResults = LottoPrize.values().map { lottoPrize ->
            val winningLottoTicketCount = lottoTickets.filter { it.countMatchingLottoNumbers(winningLottoNumbers) == lottoPrize.matchCount }.size
            LottoTicketWinningResult(lottoPrize, winningLottoTicketCount)
        }

        val totalLottoPrizeMoney = lottoTicketWinningResults
            .sumOf { it.totalWinningPrizeMoney }
        totalRateOfReturn = totalLottoPrizeMoney.toDouble() / purchaseMoney.toDouble()
    }
}
