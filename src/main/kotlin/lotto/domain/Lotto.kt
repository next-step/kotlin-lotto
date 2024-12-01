package lotto.domain

class Lotto private constructor(val lottoNumbers: Set<LottoNumber>) {
    companion object {
        fun createLotto(numbers: List<Int>): Lotto {
            val lottoNumbers = numbers.map { LottoNumber.from(it) }.toSet()

            return Lotto(lottoNumbers)
        }
    }
}
