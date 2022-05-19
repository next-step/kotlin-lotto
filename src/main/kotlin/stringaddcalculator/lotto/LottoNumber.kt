package stringaddcalculator.lotto

@JvmInline
value class LottoNumber(
    private val value: Int
) : Comparable<LottoNumber> {

    init {
        require(value in LOTTO_NUMBER_RANGE)
    }

    override fun compareTo(other: LottoNumber) = value.compareTo(other.value)

    companion object {
        const val MIN_VALUE = 1
        const val MAX_VALUE = 45
        private val LOTTO_NUMBER_RANGE = MIN_VALUE..MAX_VALUE
    }
}
