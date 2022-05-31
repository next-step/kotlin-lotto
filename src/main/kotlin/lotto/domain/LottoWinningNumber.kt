package lotto.domain

class LottoWinningNumber(val numbers: Set<Int>) {
    private val winningNumber: LottoTicket = LottoTicket(numbers)
}
