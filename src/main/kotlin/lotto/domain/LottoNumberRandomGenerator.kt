package lotto.domain

class LottoNumberRandomGenerator(private val min: Int, private val max: Int) : LottoNumberGenerator {
    constructor() : this(LottoNumber.LOTTO_MINIMUM_NUMBER, LottoNumber.LOTTO_MAXIMUM_NUMBER)

    override fun pickNumber(): Int {
        return (min..max).shuffled()[0]
    }
}
