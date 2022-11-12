package lotto

class WinnerTicket(
    private val winnerNumbers: Set<LottoNumber>
) {
    init {
        require(winnerNumbers.size == 6)
    }

    fun countMatchNumbers(lottoTicket: LottoTicket): Int {
        return lottoTicket.count(winnerNumbers::contains)
    }

    companion object {
        fun of(numbers: Set<Int>): WinnerTicket {
            return WinnerTicket(numbers.map { LottoNumber(it) }
                .toSet())
        }
    }
}