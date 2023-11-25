package lotto.domain

class LottoGameResult(
    purchaseMoney: Long,
    winningLottoNumbers: LottoNumbers,
    lottoTickets: List<LottoTicket>,
) {
    private val winningLottoTicketCountByLottoPrize: Map<LottoPrize, Int>
    val totalRateOfReturn: Double

    init {
        winningLottoTicketCountByLottoPrize = initWinningLottoTicketCountByLottoPrize(lottoTickets, winningLottoNumbers)
        totalRateOfReturn = initTotalRateOfReturn(purchaseMoney)
    }

    fun getWinningLottoTicketCountBy(lottoPrize: LottoPrize): Int {
        return winningLottoTicketCountByLottoPrize.getOrDefault(lottoPrize, 0)
    }

    private fun initWinningLottoTicketCountByLottoPrize(
        lottoTickets: List<LottoTicket>,
        winningLottoNumbers: LottoNumbers,
    ): Map<LottoPrize, Int> {
        return lottoTickets
            .mapNotNull { LottoPrize.of(it.countMatchingLottoNumbers(winningLottoNumbers)) }
            .groupingBy { it }
            .eachCount()
    }

    private fun initTotalRateOfReturn(purchaseMoney: Long): Double {
        val totalLottoPrizeMoney = winningLottoTicketCountByLottoPrize
            .map { it.key.prizeMoney * it.value }
            .sum()
        return totalLottoPrizeMoney.toDouble() / purchaseMoney.toDouble()
    }
}
