package lotto.domain

class WinningLotto(val lottoNumbers: LottoNumbers) {
    fun getNumbers(): List<LottoNumber> {
        return lottoNumbers.getNumbers()
    }

    companion object {
        fun create(numbers: List<Int>): WinningLotto {
            val lottoNumbers = LottoNumbers(numbers.map { LottoNumber(it) })
            return WinningLotto(lottoNumbers)
        }
    }
}
