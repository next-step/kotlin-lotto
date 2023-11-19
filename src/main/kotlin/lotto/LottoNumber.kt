package lotto
@JvmInline
value class LottoNumber(val number: Int) {

    companion object {
        private const val MIN_NUMBER = 1
        private const val MAX_NUMBER = 46
        val LOTTO_NUMBERS = (MIN_NUMBER until MAX_NUMBER).map { LottoNumber(it) }

        fun valueOf(input: Int): LottoNumber {
            if (input in MIN_NUMBER until MAX_NUMBER) {
                return LottoNumber(input)
            } else {
                throw IllegalArgumentException("Invalid LottoNumber: $input. $MIN_NUMBER and ${MAX_NUMBER - 1} 사이의 값이여야 합니다.")
            }
        }
    }
}
