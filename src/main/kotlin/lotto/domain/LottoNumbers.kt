package lotto.domain

class LottoNumbers(val lottoNumbers: List<LottoNumber>) {
    companion object {
        fun of(lottoNumbers: List<Int>): LottoNumbers {
            return LottoNumbers(lottoNumbers.map { LottoNumber(it) })
        }
    }
}
