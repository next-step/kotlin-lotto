package lotto.business

class LottoWinningNumbers(override val lottoNumbers: Set<LottoNumber>) : LottoNumberSet {
    init {
        validateNumbers()
    }

    private val _sortedLottoNumbers = sortedLottoNumbers()

    val sortedLottoNumbers: List<LottoNumber>
        get() = _sortedLottoNumbers

    fun compilePrizeResults(tickets: List<LottoTicket>): PrizeResults {
        return tickets.map { it.matchCount(_sortedLottoNumbers) }
            .map { LotteryPrize.getPrize(it) }
            .groupingBy { it }
            .eachCount()
            .let { PrizeResults(it) }
    }
}
