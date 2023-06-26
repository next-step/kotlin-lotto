package lotto

class LottoNumbers(private val lottoNumbers: List<LottoNumber>) : List<LottoNumber> by lottoNumbers {
    override fun toString(): String {
        return lottoNumbers.toString()
    }
}
