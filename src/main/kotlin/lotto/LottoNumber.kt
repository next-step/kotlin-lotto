package lotto

@JvmInline
value class LottoNumber(val value: Int) {
    companion object {
        private val LOTTO_NUMBER_RANGE = 1..45

        fun generate(): LottoNumber {
            return LottoNumber((LOTTO_NUMBER_RANGE).random())
        }
    }
}
