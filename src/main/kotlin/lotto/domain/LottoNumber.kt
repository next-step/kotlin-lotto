package lotto.domain

@JvmInline
value class LottoNumber(val number: Int) {
    init {
        require(number in lottoNumberRange)
    }

    companion object {
        const val START_LOTTO_NUMBER = 1
        const val END_LOTTO_NUMBER = 45
        val lottoNumberRange = START_LOTTO_NUMBER..END_LOTTO_NUMBER
    }
}
