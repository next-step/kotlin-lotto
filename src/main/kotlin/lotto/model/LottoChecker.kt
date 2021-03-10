package lotto.model

class LottoChecker(private val winningNumbers: WinningNumbers) {
    fun check(tickets: LottoTickets, sumCostOfTickets: Money): LottoResult {
        val winningCounter = WinningCounter()

        tickets.forEach {
            val matchCount = it.countMatch(winningNumbers)

            winningCounter.record(matchCount)
        }

        return LottoResult(winningCounter, sumCostOfTickets)
    }
}
