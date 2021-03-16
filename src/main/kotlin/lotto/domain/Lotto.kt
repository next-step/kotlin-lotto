package lotto.domain

class Lotto(val _numbers: MutableList<LottoNumber> = mutableListOf()) {
    val numbers: List<LottoNumber>
        get() = _numbers

    init {
        repeat(LOTTO_NUMBER_COUNT) {
            _numbers.add(LottoNumber(1))
        }
    }

    companion object {
        const val LOTTO_NUMBER_COUNT = 6
    }
}
