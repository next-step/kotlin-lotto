package lotto.domain.ticket

import lotto.domain.LottoNumber

class WinningLottoTicket(
    val numbers: List<LottoNumber>
) {
    init {
        if (numbers.size != WINNING_NUMBER_SIZE) {
            throw IllegalArgumentException("우승 번호의 갯수는 ${WINNING_NUMBER_SIZE}개여야 합니다. size: ${numbers.size}")
        }
    }

    fun compare(ticket: LottoTicket): WinningBoard {
        val matchNumbers = mutableListOf<LottoNumber>()
        numbers.forEach {
            ticket.fillMatchNumber(matchNumbers, it)
        }
        return WinningBoard.findBy(matchNumbers.size)
    }

    companion object {
        const val WINNING_NUMBER_SIZE = 6
    }
}
