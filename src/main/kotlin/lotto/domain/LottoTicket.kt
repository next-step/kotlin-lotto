package lotto.domain

data class LottoTicket(
    val numbers: List<Int>,
) {
    fun countMatched(winningNumbers: WinningNumbers): Int =
        numbers.count { winningNumbers.isInWinningNumbers(it) }
}
