package lotto.domain

class LottoNumberRandomGenerator(private val min: Int, private val max: Int) : LottoNumberGenerator {
    override val number: Int
        get() = (min..max).shuffled()[0]

    constructor() : this(LottoNumber.LOTTO_MINIMUM_NUMBER, LottoNumber.LOTTO_MAXIMUM_NUMBER)
}
