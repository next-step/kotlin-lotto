package lotto.domain

class Lotto(val _numbers: MutableList<LottoNumber> = mutableListOf(), generator: LottoNumberGenerator) {
    val numbers: List<LottoNumber>
        get() = _numbers

    init {
        repeat(LOTTO_NUMBER_COUNT) {
            _numbers.add(LottoNumber(generator.number))
        }
    }

    companion object {
        const val LOTTO_NUMBER_COUNT = 6
    }
}
