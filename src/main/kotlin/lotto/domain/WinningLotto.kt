package lotto.domain

class WinningLotto(
    private val lottoNumbers: LottoNumbers,
    private val bonusNumber: LottoNumber
) {
    fun getNumbers(): List<LottoNumber> {
        return lottoNumbers.getNumbers()
    }

    fun match(lottos: List<Lotto>): LottoResult {
        val result = buildMap<Revenue, Int> {
            lottos.forEach { lotto ->
                val matchCount = calcMatchCount(lotto.lottoNumbers)
                if (matchCount >= LottoResult.MINIMUM_MATCH_COUNT) {
                    val isMatchedBonus = calcBonusNumberMatch(lotto.lottoNumbers)
                    val key = Revenue.of(matchCount, isMatchedBonus)
                    this[key] = (this.getOrDefault(key, 0)) + 1
                }
            }
        }

        return LottoResult(result.toMap())
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
