package lotto.domain

class Lotto(val lottoNumbers: Set<LottoNumber>) {

    init {
        require(lottoNumbers.size == LOTTO_SIZE) { "로또 번호는 중복되지 않아야 합니다." }
    }

    constructor(vararg numbers: Int) : this(numbers.map { LottoNumber(it) }.toSet())

    fun contains(bonusNumber: LottoNumber): Boolean {
        return lottoNumbers.contains(bonusNumber)
    }

    companion object {
        private const val LOTTO_SIZE = 6;
        fun from(numberGenerator: LottoNumberGenerator): Lotto {
            val numbers = numberGenerator.generate(LOTTO_SIZE)
            return Lotto(numbers)
        }
    }

}
