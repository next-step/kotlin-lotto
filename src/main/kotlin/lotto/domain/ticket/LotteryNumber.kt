package lotto.domain.ticket

@JvmInline
value class LotteryNumber(val value: Int = LOTTERY_NUMBER_VALID_RANGE.random()) {
    init {
        require(value in LOTTERY_NUMBER_VALID_RANGE) { ERR_INVALID_VALUE }
    }

    companion object {
        const val STARTING_VALUE = 1
        const val ENDING_VALUE = 45
        const val ERR_INVALID_VALUE = "[ERROR] The given number must be in the range $STARTING_VALUE to $ENDING_VALUE"

        val LOTTERY_NUMBER_VALID_RANGE = STARTING_VALUE..ENDING_VALUE
    }
}
