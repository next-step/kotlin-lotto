package lotto.vo

@JvmInline
value class LotteryNumber(private val value: Int) : Comparable<LotteryNumber> {

    init {
        require(value in MIN_LOTTO_NUMBER..MAX_LOTTO_NUMBER)
    }

    override fun toString() = "$value"

    override fun compareTo(other: LotteryNumber): Int = value - other.value

    companion object {

        const val MIN_LOTTO_NUMBER = 1
        const val MAX_LOTTO_NUMBER = 45

        fun of(value: Int) = LotteryNumber(value)
    }
}
