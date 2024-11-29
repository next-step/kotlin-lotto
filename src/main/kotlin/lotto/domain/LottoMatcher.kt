package lotto.domain

class LottoMatcher(private val winningLotto: Lotto, private val bonusNumber: LottoNumber) {
    fun match(ticket: Lotto): WinningCategory {
        val matchCount = ticket.getNumbers().count { it in winningLotto.getNumbers() }
        val matchBonus = ticket.getNumbers().contains(bonusNumber)
        return WinningCategory.fromMatchCount(matchCount, matchBonus)
    }
}
