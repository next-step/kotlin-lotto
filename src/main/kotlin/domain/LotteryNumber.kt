package domain

class LotteryNumber private constructor(private val number: Int) {
    companion object {
        private const val MIN_RANDOM_NUMBER = 0
        private const val MAX_RANDOM_NUMBER = 45
        private val NUMBERS: Map<Int, LotteryNumber> =
            (MIN_RANDOM_NUMBER..MAX_RANDOM_NUMBER).associateWith { LotteryNumber(it) }

        fun from(number: Int): LotteryNumber {
            return NUMBERS[number] ?: throw IllegalArgumentException("잘못된 로또 번호입니다.")
        }
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as LotteryNumber

        if (number != other.number) return false

        return true
    }

    override fun hashCode(): Int {
        return number
    }

    override fun toString(): String {
        return number.toString()
    }
}
