package lotto

enum class LottoRank(
    val matchCount: Int,
    private val winningMoney: Money,
) {
    FIRST(6, Money(2_000_000_000)),
    SECOND(5, Money(30_000_000)),
    THIRD(5, Money(1_500_000)),
    FOURTH(4, Money(50_000)),
    FIFTH(3, Money(5_000)),
    SIXTH(2, Money(0)),
    SEVENTH(1, Money(0)),
    NONE(0, Money(0)),
    ;

    fun sumPrice(count: Count): Int {
        return winningMoney.value * count.value
    }

    fun getPriceValue(): Int {
        return winningMoney.value
    }

    companion object {
        fun valueOf(matchCount: Int): LottoRank {
            val find = entries.find { it.matchCount == matchCount }
            return find ?: NONE
        }

        fun valueOf(value: Int, bonusMatch: Boolean): LottoRank {
            return when (value) {
                SECOND.matchCount -> if (bonusMatch) SECOND else THIRD
                else -> valueOf(value)
            }
        }
    }
}
