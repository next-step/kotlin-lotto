package lotto.domain

import lotto.dto.LottoResult

private const val WINNER_TICKET_SIZE = 6

class WinnerTicket(
    private val winnerNumbers: Set<LottoNumber>
) {
    init {
        require(winnerNumbers.size == WINNER_TICKET_SIZE)
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