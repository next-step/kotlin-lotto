package lotto

object LottoResultHandler {
    fun match(
        userLotto: List<LottoNumbers>,
        winningLotto: LottoNumbers,
    ): LottoResults {
        val lottoResults = LottoResults()
        userLotto.map {
            val matchCount = it.countMatch(winningLotto)
            lottoResults.counting(LottoResult(LottoRank.valueOf(matchCount)))
        }
        return lottoResults
    }
}
