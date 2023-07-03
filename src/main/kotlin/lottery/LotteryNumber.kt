package lottery

@JvmInline
value class LotteryNumber private constructor(
    private val number: Int,
) {
    init {
        require(number >= MIN_LOTTERY_NUMBER) { "로또 번호는 1이상여야 합니다." }
        require(number <= MAX_LOTTERY_NUMBER) { "로또 번호는 45이하이여야 합니다." }
    }

    companion object {
        fun get(number: Int) = LotteryNumber(number)

        const val MAX_LOTTERY_NUMBER = 45
        const val MIN_LOTTERY_NUMBER = 1
    }

    override fun toString(): String {
        return "$number"
    }
}
