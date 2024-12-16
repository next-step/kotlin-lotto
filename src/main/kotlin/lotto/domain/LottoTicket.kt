package lotto.domain

sealed class LottoTicket {
    abstract val lottoNumbers: LottoNumbers

    fun checkLottoWinnerRank(lottoWinnerNumbers: LottoWinnerNumbers): LottoWinnerRank {
        val matchCount = lottoNumbers.checkLottoNumbersMatch(lottoWinnerNumbers.lottoNumbers)
        val bonusCheck = lottoNumbers.contains(lottoWinnerNumbers.bonusNumber)
        return LottoWinnerRank.getRankByMatches(matchCount = matchCount, bonusCheck = bonusCheck)
    }

    class ManualLottoTicket(override val lottoNumbers: LottoNumbers) : LottoTicket()

    class AutoLottoTicket(generateLottoNumbers: () -> LottoNumbers) : LottoTicket() {
        override val lottoNumbers: LottoNumbers = generateLottoNumbers()
    }
}
