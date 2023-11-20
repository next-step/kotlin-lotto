package lotto.domain

class WinningLotto(
    private val lottoNumbers: LottoNumbers,
    private val bonusNumber: LottoNumber
) {
    fun getNumbers(): List<LottoNumber> {
        return lottoNumbers.getNumbers()
    }

    fun match(lottos: List<Lotto>): LottoResult {
        val lottoResult = LottoResult()
        lottos.forEach { lotto ->
            val matchCount = calcMatchCount(lotto.lottoNumbers)
            val isMatchedBonus = calcBonusNumberMatch(lotto.lottoNumbers)
            lottoResult.prepareLottoResult(matchCount, isMatchedBonus)
        }
        return lottoResult
    }

    private fun calcMatchCount(lottoNumbers: LottoNumbers): Int {

        return this.lottoNumbers.getMatchCount(lottoNumbers)
    }

    private fun calcBonusNumberMatch(lottoNumbers: LottoNumbers): Boolean {
        return lottoNumbers.getNumbers().contains(bonusNumber)
    }

    companion object {
        fun create(numbers: List<Int>, bonusNumber: Int): WinningLotto {
            val lottoNumbers = LottoNumbers(numbers.map { LottoNumber(it) })
            return WinningLotto(lottoNumbers, LottoNumber(bonusNumber))
        }
    }
}
