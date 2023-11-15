package lotto.domain

class WinningLotto(val lottoNumbers: LottoNumbers) {
    fun getNumbers(): List<LottoNumber> {
        return lottoNumbers.getNumbers()
    }

    fun match(lottos: List<Lotto>): LottoResult {
        val lottoResult = LottoResult()
        lottos.forEach { lotto ->
            val lottoNumber = lotto.getNumbers()
            var count = 0
            lottoNumber.forEach { number ->
                if (getNumbers().contains(number)) {
                    count++
                }
            }

            lottoResult.setLottoResult(count)
        }
        return lottoResult
    }

    companion object {
        fun create(numbers: List<Int>): WinningLotto {
            val lottoNumbers = LottoNumbers(numbers.map { LottoNumber(it) })
            return WinningLotto(lottoNumbers)
        }
    }
}
