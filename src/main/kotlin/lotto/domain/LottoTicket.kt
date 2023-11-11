package lotto.domain

data class LottoTicket(
    val numbers: List<Int>,
) {
    fun countMatched(winningNumbers: WinningNumbers): Int =
        numbers.count { winningNumbers.isInWinningNumbers(it) }

    infix fun contains(number: Number): Boolean =
        numbers.contains(number)

    infix fun countMatched(other: LottoTicket) =
        numbers.count { other contains it }
}
