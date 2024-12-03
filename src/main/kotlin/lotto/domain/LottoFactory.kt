package lotto.domain

object LottoFactory {
    fun createManualTickets(rawNumbers: List<String>): LottoTickets {
        val tickets =
            rawNumbers.map { numbers ->
                val parsedNumbers = numbers.split(",").map { it.trim().toInt() }
                Lotto.of(parsedNumbers)
            }
        return LottoTickets(tickets)
    }

    fun createWinningLotto(
        winningNumbers: String,
        bonusNumber: Int,
    ): WinningLotto {
        val numbers = winningNumbers.split(",").map { it.trim().toInt() }
        val lotto = Lotto.of(numbers)
        val bonus = LottoNumber.of(bonusNumber)
        return WinningLotto(lotto, bonus)
    }
}
