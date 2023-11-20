package lotto.domain

class LottoGameResult(
    purchaseMoney: Long,
    winningLottoNumbers: LottoNumbers,
    lottoTickets: List<LottoTicket>,
) {
    private val winningLottoTicketCountByLottoPrize: Map<LottoPrize, Int>
    val totalRateOfReturn: Double

    init {
        // 각 로또 상금별 당첨 티켓 수 계산
        winningLottoTicketCountByLottoPrize = LottoPrize.values()
            .associateWith { lottoPrize ->
                lottoTickets.count {
                    it.countMatchingLottoNumbers(winningLottoNumbers) == lottoPrize.matchCount
                }
            }

        // 총 상금 계산
        val totalLottoPrizeMoney = winningLottoTicketCountByLottoPrize
            .map { it.key.prizeMoney * it.value }
            .sum()

        // 수익률 계산
        totalRateOfReturn = totalLottoPrizeMoney.toDouble() / purchaseMoney.toDouble()
    }

    fun getWinningLottoTicketCountBy(lottoPrize: LottoPrize): Int {
        return winningLottoTicketCountByLottoPrize[lottoPrize] ?: 0
    }
}
