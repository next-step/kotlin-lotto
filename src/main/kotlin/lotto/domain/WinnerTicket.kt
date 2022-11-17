package lotto.domain

import lotto.dto.LottoResult

private const val WINNER_TICKET_SIZE = 6

class WinnerTicket(
    private val winnerNumbers: Set<LottoNumber>,
    private val bonus: LottoNumber
) {
    init {
        require(winnerNumbers.size == WINNER_TICKET_SIZE) { "당첨 티켓의 당첨번호는 6개의 숫자로 이루어져야 합니다." }
        require(!winnerNumbers.contains(bonus)) { "보너스 번호는 당첨번호와 중복되면 안됩니다." }
    }

    constructor(numbers: Set<Int>, bonusNumber: Int) : this(
        numbers.map { LottoNumber(it) }.toSet(),
        LottoNumber(bonusNumber)
    )

    fun drawResult(lottoTicket: LottoTicket): LottoResult {
        return LottoResult.fromMatchCount(
            winnerNumbers.count { lottoTicket.hasNumber(it) },
            lottoTicket.hasNumber(bonus)
        )
    }
}
