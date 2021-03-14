package lotto.model.number

abstract class LottoNumbers(private val lottoNumbers: Set<LottoNumber>) : Set<LottoNumber> by lottoNumbers {
    override fun toString(): String {
        return lottoNumbers.joinToString(separator = ", ", prefix = "[", postfix = "]")
    }
}
