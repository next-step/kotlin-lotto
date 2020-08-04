package lotto.domain.value

data class Money(private val won: Int) {
    init {
        if (won < ZERO) throw IllegalArgumentException("음수는 Money로 사용될 수 없습니다.")
    }

    fun won() = won

    operator fun plus(money: Money) = Money(won.plus(money.won))

    operator fun minus(money: Money) = Money(won.minus(money.won))

    operator fun times(count: Int) = Money(won * count)

    operator fun div(count: Double) = won.div(count)

    operator fun div(count: Int) = won.div(count)

    override fun toString() = "${won}원"

    fun toDouble() = won.toDouble()

    companion object {
        private const val ZERO = 0
    }
}
