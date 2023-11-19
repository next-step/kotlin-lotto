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
            val (matchCount, isMatchedBonus) = calcMatchCount(lotto.lottoNumbers)
            lottoResult.setLottoResult(matchCount, isMatchedBonus)
        }
        return lottoResult
    }

    private fun calcMatchCount(lottoNumbers: LottoNumbers): Pair<Int, Boolean> {
        var count = 0
        lottoNumbers.getNumbers().forEach { number ->
            if (getNumbers().contains(number)) {
                count++
            }
        }

        return count to lottoNumbers.getNumbers().contains(bonusNumber)
    }


    companion object {
        fun create(numbers: List<Int>, bonusNumber: Int): WinningLotto {
            val lottoNumbers = LottoNumbers(numbers.map { LottoNumber(it) })
            return WinningLotto(lottoNumbers, LottoNumber(bonusNumber))
        }
    }
}
