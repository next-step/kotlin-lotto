package lotto.domain

class LottoMatcher(private val winningNumbers: List<LottoNumber>) {
    fun match(ticket: Lotto): WinningCategory {
        val matchCount = ticket.getNumbers().count { it.number in winningNumbers.map { it.number } }
        return WinningCategory.fromMatchCount(matchCount)
    }
}
