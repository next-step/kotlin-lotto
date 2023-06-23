package lotto.domain

class LottoMatcher(private val winningNumbers: List<Int>) {
    fun getMatchingResult(lottoTicket: LottoTicket): LottoResult {
        val map = lottoTicket.numbers
            .map { numbers -> countMatchingNumbers(numbers) }
            .groupingBy { it }
            .eachCount()
        return LottoResult(map)
    }

    private fun countMatchingNumbers(myNumbers: Numbers) = myNumbers.values.count { winningNumbers.contains(it) }
}