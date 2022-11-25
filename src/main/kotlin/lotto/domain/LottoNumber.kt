package lotto.domain

@JvmInline
value class LottoNumber(val value: Int) {
    init {
        require(value in MINIMUM_LOTTO_NUMBER..MAXIMUM_LOTTO_NUMBER) { "로또 번호는 1~45 사이의 숫자만 가능합니다." }
    }

    companion object {
        const val MINIMUM_LOTTO_NUMBER = 1
        const val MAXIMUM_LOTTO_NUMBER = 45
    }
}
