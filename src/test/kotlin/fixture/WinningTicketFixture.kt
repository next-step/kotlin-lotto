package fixture

import lotto.domain.LottoNumber
import lotto.domain.LottoTicket
import lotto.domain.WinningTicket

object WinningTicketFixture {

    fun winningTicket(numbers: List<Int>, bonusNumber: Int): WinningTicket {
        return WinningTicket(
            LottoTicket(numbers.map { LottoNumber.of(it) }),
            LottoNumber.of(bonusNumber)
        )
    }
}
