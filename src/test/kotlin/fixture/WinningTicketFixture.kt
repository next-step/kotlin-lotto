package fixture

import lotto.domain.WinningTicket

object WinningTicketFixture {
    fun winningTicket(vararg numbers: Int): WinningTicket {
        return winningTicket(numbers.toList(), 45)
    }

    fun winningTicket(numbers: List<Int>, bonusNumber: Int): WinningTicket {
        return WinningTicket.of(numbers, bonusNumber)
    }
}
