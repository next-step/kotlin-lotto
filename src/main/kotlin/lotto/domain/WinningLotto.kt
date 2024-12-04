package lotto.domain

class WinningLotto(private val winningLotto: Lotto, private val bonusNumber: LottoNumber) {
    init {
        require(!winningLotto.hasNumber(bonusNumber)) {
            "Bonus number must not be one of the winning numbers."
        }
    }

    private fun determineCategory(ticket: Lotto): WinningCategory {
        val matchCount = ticket.countMatchingNumbers(winningLotto)
        val matchBonus = ticket.hasNumber(bonusNumber)
        return WinningCategory.fromMatchCount(matchCount, matchBonus)
    }

    fun evaluateTickets(tickets: LottoTickets): List<WinningCategory> {
        return tickets.getTickets().map { determineCategory(it) }
    }
}
