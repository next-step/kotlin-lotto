package lotto.domain

class LottoNumberRandomGenerator(private val min: Int, private val max: Int) : LottoNumberGenerator {
    constructor() : this(LottoNumber.LOTTO_MINIMUM_NUMBER, LottoNumber.LOTTO_MAXIMUM_NUMBER)

    override fun pickNumber(): Set<LottoNumber> {
        return (min..max).shuffled().slice(0..5).map { LottoNumber.from(it) }.toSet()
    }
}
