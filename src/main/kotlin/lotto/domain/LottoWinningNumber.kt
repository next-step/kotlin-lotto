package lotto.domain

class LottoWinningNumber(
    numbers: Set<Int>,
    val bonusNumber: Int
) {
    val winningNumber: LottoTicket = LottoTicket(numbers)
}
