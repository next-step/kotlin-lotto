package lotto.vo

@JvmInline
value class LotteryNumber(private val value: Int) {

    init {
        require(value in MIN_LOTTO_NUMBER..MAX_LOTTO_NUMBER)
    }

    companion object {

        const val MIN_LOTTO_NUMBER = 1
        const val MAX_LOTTO_NUMBER = 45
    }
}
