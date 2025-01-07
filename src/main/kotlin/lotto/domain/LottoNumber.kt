package lotto.domain

@JvmInline
value class LottoNumber(val number: Int) {
    init {
        require(number in START_LOTTO_NUMBER..END_LOTTO_NUMBER)
    }

    companion object {
        const val START_LOTTO_NUMBER = 1
        const val END_LOTTO_NUMBER = 45
    }
}
