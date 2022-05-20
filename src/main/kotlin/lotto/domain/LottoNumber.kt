package lotto.domain

@JvmInline
value class LottoNumber(
    private val value: Int
) : Comparable<LottoNumber> {

    init {
        require(value in LOTTO_NUMBER_RANGE)
    }

    override fun compareTo(other: LottoNumber) = value.compareTo(other.value)

    companion object {
        val LOTTO_NUMBER_RANGE = 1..45
    }
}
