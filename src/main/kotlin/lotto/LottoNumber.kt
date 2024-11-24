package lotto

@JvmInline
value class LottoNumber(val value: Int) {
    companion object {
        private const val LOTTO_MIN_NUMBER = 1
        private const val LOTTO_MAX_NUMBER = 45

        fun generate(): LottoNumber {
            return LottoNumber((LOTTO_MIN_NUMBER..LOTTO_MAX_NUMBER).random())
        }
    }
}