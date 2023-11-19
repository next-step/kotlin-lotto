package lotto.domain

@JvmInline
value class LottoNumber(val value: Int) {
    init {
        require(value in LOTTO_START_NUMBER..LOTTO_END_NUMBER) { "로또에는 1 ~ 45 사이의 숫자만 적힐 수 있습니다" }
    }

    companion object {
        const val LOTTO_START_NUMBER = 1
        const val LOTTO_END_NUMBER = 45
    }
}
