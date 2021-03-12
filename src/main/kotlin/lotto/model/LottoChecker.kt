package lotto.model

class LottoChecker(private val winningNumbers: WinningNumbers, private val bonusNumbers: BonusNumbers) {
    fun check(tickets: LottoTickets): WinningCounter {
        val winningCounter = WinningCounter()

        tickets.forEach {
            val winningCount = it.countMatch(winningNumbers)
            val bonusCount = it.countMatch(bonusNumbers)

            winningCounter.record(winningCount, bonusCount)
        }

        return winningCounter
    }
}
