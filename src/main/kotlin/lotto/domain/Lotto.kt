package lotto.domain
class Lotto(val lottoNumbers: Set<LottoNumber>) {
    init {
        require(lottoNumbers.size == 6) { "로또 번호는 중복되지 않아야 합니다." }
    }
    constructor(vararg numbers: Int) : this(numbers.map { LottoNumber(it) }.toSet())

    companion object {
        fun from(numberGenerator: LottoNumberGenerator): Lotto {
            val numbers = numberGenerator.generate()
            return Lotto(numbers)
        }
    }
}
