package lotto.domain.ticket.lottery

import lotto.domain.ticket.lottery.LotteryNumber.Companion.LOTTERY_NUMBER_VALID_RANGE

@JvmInline
value class LotteryNumbers private constructor(
    private val _lotteryNumbers: Set<LotteryNumber>
) {
    init {
        require(LOTTERY_NUMBERS_SIZE == _lotteryNumbers.size) { ERR_INVALID_SIZE }
    }

    val values: List<Int>
        get() = _lotteryNumbers.map { it.value }

    val size: Int
        get() = _lotteryNumbers.size

    fun numberOfMatchesWithWinningNumbers(winningLotteryNumbers: LotteryNumbers): Int {
        return _lotteryNumbers.count {
            it.value in winningLotteryNumbers.values
        }
    }

    companion object {
        const val LOTTERY_NUMBERS_SIZE: Int = 6

        private const val ERR_INVALID_SIZE = "[ERROR] The lottery number size must be $LOTTERY_NUMBERS_SIZE"
        private const val START_INDEX = 0
        private const val END_INDEX = 6

        fun quickPick(): LotteryNumbers {
            val randomLotteryNumbers = LOTTERY_NUMBER_VALID_RANGE.shuffled()
                .subList(START_INDEX, END_INDEX)
                .map { LotteryNumber(it) }
                .toSet()

            return LotteryNumbers(randomLotteryNumbers)
        }

        fun of(givenNumbers: List<Int>): LotteryNumbers {
            val uniqueNumberSet = givenNumbers.toSet()

            if (uniqueNumberSet.size != LOTTERY_NUMBERS_SIZE) {
                throw IllegalArgumentException(ERR_INVALID_SIZE)
            }

            return LotteryNumbers(
                uniqueNumberSet.map {
                    LotteryNumber(it)
                }.toSet()
            )
        }
    }
}
