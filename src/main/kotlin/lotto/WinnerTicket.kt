package lotto

class WinnerTicket(
    private val winnerNumbers: Set<LottoNumber>
) {
    init {
        require(winnerNumbers.size == 6)
    }

    fun drawResult(lottoTicket: LottoTicket): LottoResult {
        return LottoResult.fromMatchCount(
            lottoTicket.countMatchNumbers(winnerNumbers::contains)
        )
    }

    companion object {
        fun of(numbers: Set<Int>): WinnerTicket {
            return WinnerTicket(numbers.map { LottoNumber(it) }
                .toSet())
        }
    }
}