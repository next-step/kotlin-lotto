package lotto

object LottoResultHandler {
    fun match(
        userLotto: List<LottoNumbers>,
        winningLotto: LottoNumbers,
    ): LottoResults {
        return userLotto.fold(LottoResults()) { lottoResults, lottoNumbers ->
            val matchCount = lottoNumbers.countMatch(winningLotto)
            lottoResults.apply { counting(LottoResult(LottoRank.valueOf(matchCount))) }
        }
    }

    fun match(userLotto: List<LottoNumbers>, winningLotto: WinningNumbers): LottoResults {
        return userLotto.fold(LottoResults()) { lottoResults, lottoNumbers ->
            val matchCount = lottoNumbers.countMatch(winningLotto.lottoNumbers)
            val bonusMatch = lottoNumbers.matchBonus(winningLotto.bonusNumber)
            lottoResults.counting(LottoResult(LottoRank.valueOf(matchCount, bonusMatch)))
        }
    }
}
