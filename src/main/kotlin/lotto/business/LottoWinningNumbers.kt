package lotto.business

class LottoWinningNumbers(lottoNumbers: Set<LottoNumber>) {
    init {
        require(lottoNumbers.size == LOTTO_NUMBER_SIZE) { "서로 다른 6개 로또 번호 이여야 합니다." }
    }

    private val _sortedLottoNumbers = lottoNumbers.sortedBy { it.number }

    val lottoNumbers: List<LottoNumber>
        get() = _sortedLottoNumbers
            .map { it }

    fun compilePrizeResults(tickets: List<LottoTicket>): PrizeResults {
        return tickets.map { it.matchCount(lottoNumbers) }
            .map { LotteryPrize.getPrize(it) }
            .groupingBy { it }
            .eachCount()
            .let { PrizeResults(it) }
    }

    companion object {
        private const val LOTTO_NUMBER_SIZE = 6
    }
}
