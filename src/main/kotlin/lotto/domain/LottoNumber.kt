package lotto.domain

@JvmInline
value class LottoNumber(private val num: Int) {
    init {
        require(num in LOTTO_START_NUM..LOTTO_END_NUM) { LOTTO_NUM_EXCEPTION }
    }

    companion object {
        private const val LOTTO_START_NUM = 1
        private const val LOTTO_END_NUM = 45
        private const val LOTTO_NUM_EXCEPTION = "로또의 숫자는 1~45의 숫자만 가능합니다."
    }
}
