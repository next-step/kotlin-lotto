package lotto.domain

class Lotto(
    private val _numbers: MutableSet<LottoNumber> = mutableSetOf(),
    generator: LottoNumberGenerator = LottoNumberRandomGenerator(
        LottoNumber.LOTTO_MINIMUM_NUMBER,
        LottoNumber.LOTTO_MAXIMUM_NUMBER
    )
) {
    val numbers: Set<LottoNumber>
        get() = _numbers

    init {
        while (_numbers.size < LOTTO_NUMBER_COUNT) {
            _numbers.add(LottoNumber(generator.number))
        }
    }

    companion object {
        const val LOTTO_NUMBER_COUNT = 6
    }
}
