package lotto.business

class WinningLottoTicket(lottoNumbers: Set<LottoNumber>) : LottoNumberSet(lottoNumbers) {
    init {
        validateNumbers()
    }

    fun compilePrizeResults(tickets: List<LottoTicket>): PrizeResults {
        return tickets.map { it.matchCount(sortedLottoNumbers) }
            .map { LotteryPrize.getPrize(it) }
            .groupingBy { it }
            .eachCount()
            .let { PrizeResults(it) }
    }
}
