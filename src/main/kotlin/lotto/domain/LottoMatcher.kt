package lotto.domain

class LottoMatcher(private val winningNumbers: List<Int>) {
    fun getMatchingResult(lottoTickets: LottoTickets): LottoResult {
        val map = lottoTickets.numbers
            .map { numbers -> countMatchingNumbers(numbers) }
            .groupingBy { LottoRank.getLottoRankByMatchCount(it) }
            .eachCount()
        return LottoResult(map)
    }

    private fun countMatchingNumbers(myNumbers: Numbers) = myNumbers.values.count { winningNumbers.contains(it) }
}