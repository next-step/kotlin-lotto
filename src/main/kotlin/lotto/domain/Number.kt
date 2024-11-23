package lotto.domain

@JvmInline
value class Number(val value: Int) : Comparable<Number> {
    init {
        require(isIncludeLottoRange(value)) { NUMBER_RANGE_EXCEPTION_MESSAGE }
    }

    override fun compareTo(other: Number): Int {
        return this.value.compareTo(other.value)
    }

    private fun isIncludeLottoRange(value: Int): Boolean = LOTTO_NUMBER_MIN <= value && value <= LOTTO_NUMBER_MAX

    companion object {
        private const val NUMBER_RANGE_EXCEPTION_MESSAGE = "숫자는 1~45의 값이어야 합니다."
        private const val LOTTO_NUMBER_MIN = 1
        private const val LOTTO_NUMBER_MAX = 45

        val cache = (LOTTO_NUMBER_MIN..LOTTO_NUMBER_MAX).map { Number(it) }
    }
}
