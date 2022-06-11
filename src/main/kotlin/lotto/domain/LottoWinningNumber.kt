package lotto.domain

class LottoWinningNumber(
    val winningNumber: LottoTicket,
    val bonusNumber: LottoNumber
) {
    constructor(numbers: Set<LottoNumber>, bonusNumber: LottoNumber) : this(LottoTicket(numbers), bonusNumber)
}
