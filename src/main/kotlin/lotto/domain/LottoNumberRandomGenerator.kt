package lotto.domain

class LottoNumberRandomGenerator(val min: Int, val max: Int) : LottoNumberGenerator {
    override val number: Int
        get() = (min..max).shuffled()[0]
}
