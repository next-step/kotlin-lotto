package lotto.domain.ticket

data class LotteryNumber(val value: Int = LOTTERY_NUMBER_VALID_RANGE.random()) {
    init {
        require(value in LOTTERY_NUMBER_VALID_RANGE)
    }

    companion object {
        private const val START_RANGE = 1
        private const val END_RANGE = 45
        private val LOTTERY_NUMBER_VALID_RANGE = START_RANGE..END_RANGE
    }
}
