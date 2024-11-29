package lotto.domain

class LottoMatcher(private val winningLotto: Lotto) {
    fun match(ticket: Lotto): WinningCategory {
        val matchCount = ticket.getNumbers().count { it in winningLotto.getNumbers() }
        return WinningCategory.fromMatchCount(matchCount)
    }
}
