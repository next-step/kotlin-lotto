package lotto.domain

@JvmInline
value class LotteryNumber(
    val value: Int
) {

    init {
        require(value in RANGE) {
            IllegalArgumentException("${MIN}부터 ${MAX}까지의 수만 가능합니다.")
        }
    }

    override fun toString(): String = value.toString()

    companion object {
        private const val MIN = 1
        private const val MAX = 45
        val RANGE = MIN..MAX
    }
}
