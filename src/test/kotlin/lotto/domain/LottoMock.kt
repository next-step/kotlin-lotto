package lotto.domain

object LottoMock {
    fun createTicketWithDefaultSpec(winningNumbers: WinningNumbers, matchedCount: Int): LottoTicket {
        val notMatchedCount = winningNumbers.value.size - matchedCount
        val notMatchedNumber = (LottoSpec.NUMBERS_RANGE.toSet() - winningNumbers.value.toSet()).shuffled().take(notMatchedCount)
        val matchedNumber = winningNumbers.value.shuffled().take(matchedCount)
        val numbers = (notMatchedNumber + matchedNumber).sorted()
        return LottoTicket(numbers)
    }

    fun createWinningNumbers(numberRange: IntRange = LottoSpec.NUMBERS_RANGE, numberCount: Int = LottoSpec.NUMBERS_COUNT) =
        WinningNumbers.of(numberRange.shuffled().take(numberCount).sorted(), numberRange, numberCount)
}
