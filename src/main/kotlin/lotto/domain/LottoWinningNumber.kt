package lotto.domain

class LottoWinningNumber(
    val winningNumber: LottoTicket,
    val bonusNumber: Int
) {
    constructor(numbers: Set<Int>, bonusNumber: Int) : this(LottoTicket(numbers), bonusNumber)
}
