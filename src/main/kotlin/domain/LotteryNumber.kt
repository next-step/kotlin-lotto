package domain

class LotteryNumber(private val number: Int) {
    companion object {
        private const val MIN_RANDOM_NUMBER = 0
        private const val MAX_RANDOM_NUMBER = 45
        private val NUMBERS: Map<Int, LotteryNumber>
                = (MIN_RANDOM_NUMBER..MAX_RANDOM_NUMBER).associateWith { LotteryNumber(it) }

        fun from(value: Int): LotteryNumber {
            return NUMBERS[value] ?: throw IllegalArgumentException("잘못된 로또 번호입니다.")
        }
    }
}
