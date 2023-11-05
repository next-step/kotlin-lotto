package lotto.domain

import io.kotest.matchers.shouldBe

object LottoMock {
    fun createTicket(winningNumbers: WinningNumbers, matchedCount: Int): LottoTicket {
        val matchedEndIndex = matchedCount - 1
        val numbers = winningNumbers.value.mapIndexed { index, number ->
            if (index <= matchedEndIndex) number
            else number + 1
        }
        return LottoTicket(numbers)
    }

    fun createWinningNumbers(numberRange: IntRange = LottoSpec.NUMBERS_RANGE, numberCount: Int = LottoSpec.NUMBERS_COUNT) =
        WinningNumbers.of(numberRange.shuffled().take(numberCount).sorted(), numberRange, numberCount)
}
