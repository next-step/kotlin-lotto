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

    fun compare(ticket: LottoTicket, bonusNumber: LottoNumber): WinningBoard {
        val matchNumbers = ticket.findMatchNumber(numbers)

        return WinningBoard.findBy(matchNumbers.size)
            .upgrade(ticket.hasNumber(bonusNumber))
    }

    fun hasNot(bonusNumber: LottoNumber) = !numbers.contains(bonusNumber)

    companion object {
        const val WINNING_NUMBER_SIZE = 6
    }
}
