package lotto.domain

data class LottoTicket(private val generateLottoNumbers: () -> Set<Int>) {
    val lottoNumbers = LottoNumbers(generateLottoNumbers().map { LottoNumber.of(it) }.toSet())

    fun checkLottoWinnerRank(lottoWinnerNumbers: LottoWinnerNumbers): LottoWinnerRank {
        val matchCount = lottoNumbers.checkLottoNumbersMatch(lottoWinnerNumbers.lottoNumbers)
        val bonusCheck = lottoNumbers.contains(lottoWinnerNumbers.bonusNumber)
        return LottoWinnerRank.getRankByMatches(matchCount = matchCount, bonusCheck = bonusCheck)
    }
}
