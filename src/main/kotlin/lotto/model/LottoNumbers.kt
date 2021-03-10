package lotto.model

class LottoNumbers(private val lottoNumbers: List<LottoNumber>) : List<LottoNumber> by lottoNumbers {
    companion object {
        fun from(numbers: List<Int>): LottoNumbers {
            return LottoNumbers(numbers.map { LottoNumber(it) })
        }
    }
}
