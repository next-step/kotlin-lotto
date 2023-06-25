package lotto.domain

class LottoMatcher(private val winningNumbers: LottoNumbers, private val bonusLottoNumber: LottoNumber) {
    fun getMatchingResult(lottoTickets: LottoTickets): LottoResult {
        return lottoTickets.values
            .map { numbers -> Pair(numbers.countMatchingNumbers(winningNumbers), hasBonusNumber(numbers)) }
            .groupingBy { LottoRank.getLottoRankByMatchCount(it.first, it.second) }
            .eachCount()
            .let { LottoResult(it) }
    }

    private fun hasBonusNumber(myNumbers: LottoNumbers): Boolean {
        return myNumbers.values.contains(bonusLottoNumber)
    }
}