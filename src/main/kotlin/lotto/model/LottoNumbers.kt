package lotto.model

class LottoNumbers(private val lottoNumbers: List<LottoNumber>) : List<LottoNumber> by lottoNumbers {
    init {
        require(lottoNumbers.size == NUMBERS_SIZE) { "로또는 6개의 로또 숫자로 이루어져 있습니다!" }
    }

    companion object {
        const val NUMBERS_SIZE = 6

        fun from(numbers: List<Int>): LottoNumbers {
            return LottoNumbers(numbers.map { LottoNumber(it) })
        }
    }
}
