package lotto

class Lotto(val lottoNumbers: List<LottoNumber>) {
    companion object {
        fun from(numberGenerator: LottoNumberGenerator): Lotto {
            val numbers = numberGenerator.generate()
            return Lotto(numbers)
        }
    }
}
