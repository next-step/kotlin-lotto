package lottery.domain

@JvmInline
value class LotteryNumber(
    val value: Int
) {
    init {
        require(value in MIN_NUMBER..MAX_NUMBER) { "로또 번호는 1~45의 수만 입력 가능하다." }
    }

    companion object {
        const val MIN_NUMBER = 1
        const val MAX_NUMBER = 45

        fun from(value: String) = LotteryNumber(value.toIntOrNull() ?: throw IllegalArgumentException("숫자만 입력 가능하다"))
    }
}
