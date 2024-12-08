package lotto.domain.data

@JvmInline
value class Lotto(val value: List<LottoNumber>) {
    init {
        require(value.size == LOTTO_COUNT) { "Number of values must be $LOTTO_COUNT but was ${value.size}" }
    }

    fun countMatchesOf(lotto: Lotto): Int {
        return this.value.count { lotto.value.contains(it) }
    }

    fun containsAny(number: LottoNumber): Boolean {
        return this.value.any { number == it }
    }

    companion object {
        const val LOTTO_COUNT = 6
    }
}

@JvmInline
value class LottoNumber(val value: Int) {
    companion object { // 로또 피드백 강의자료 참고
        private const val MIN_LOTTO_NUMBER = 1
        private const val MAX_LOTTO_NUMBER = 45
        private val NUMBERS : Map<Int, LottoNumber> = (MIN_LOTTO_NUMBER .. MAX_LOTTO_NUMBER).associateWith(::LottoNumber)

        fun from(value: Int) : LottoNumber {
            return NUMBERS[value] ?: throw IllegalArgumentException("Lotto number out of range [$MIN_LOTTO_NUMBER, $MAX_LOTTO_NUMBER]")
        }
    }
}