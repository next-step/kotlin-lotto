package lotto.domain

object LottoMock {

    fun createTicket(winningLotto: WinningLotto, matchedCount: Int, hasMatchedBonus: Boolean): LottoTicket {
        require(matchedCount in 0..6) { "맞는 수 범위는 1에서 6사이의 숫자여야 합니다" }
        require(!hasMatchedBonus || matchedCount < 6) { "보너스 숫자가 맞았다면 당첨 번호랑 맞는 숫자는 6보다 작아야 합니다" }
        val notMatchedNumber = createMismatchedNumbers(winningLotto)

        val matchedNumbers = winningLotto.winningTicket.numbers.take(matchedCount)
        return when (hasMatchedBonus) {
            true -> matchedNumbers + notMatchedNumber.take(5 - matchedCount) + listOf(winningLotto.bonusNumber)
            false -> matchedNumbers + notMatchedNumber.take(6 - matchedCount)
        }.let(::LottoTicket)
    }

    fun createTicket() =
        createNumbers().let(::LottoTicket)

    private fun createMismatchedNumbers(winningLotto: WinningLotto) =
        (1..45).filterNot { winningLotto.winningTicket.contains(it) || winningLotto.bonusNumber == it }.take(6)

    private fun createNumbers() =
        (1..45).shuffled().take(6).sorted()
}
