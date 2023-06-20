package lotto.domain.lottery

@JvmInline
value class LotteryNumber(private val number: Int) : Comparable<LotteryNumber> {
    init {
        require(number in LOTTERY_NUMBER_RANGE) { "로또의 숫자는 1~45 사이의 정수가 가능합니다." }
    }

    override operator fun compareTo(other: LotteryNumber): Int = compareValues(this.number, other.number)
    companion object {
        val LOTTERY_NUMBER_RANGE = (1..45)
    }

    override fun toString(): String {
        return "$number"
    }
}
