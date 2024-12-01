package lotto.domain

class WinningLotto(private val winningLotto: Lotto, private val bonusNumber: LottoNumber) {
    fun determineCategory(ticket: Lotto): WinningCategory {
        val matchCount = ticket.countMatchingNumbers(winningLotto)
        val matchBonus = ticket.hasNumber(bonusNumber)
        return WinningCategory.fromMatchCount(matchCount, matchBonus)
    }
}
