package lotto.domain

@JvmInline
value class LottoNumber(val value: Int) {
    companion object { // 로또 피드백 강의자료 참고
        private const val MIN_LOTTO_NUMBER = 1
        private const val MAX_LOTTO_NUMBER = 45
        private val NUMBERS: Map<Int, LottoNumber> = (MIN_LOTTO_NUMBER..MAX_LOTTO_NUMBER).associateWith(::LottoNumber)

        fun from(value: Int): LottoNumber {
            return NUMBERS[value] ?: throw IllegalArgumentException("Lotto number out of range [$MIN_LOTTO_NUMBER, $MAX_LOTTO_NUMBER]")
        }
    }
}
