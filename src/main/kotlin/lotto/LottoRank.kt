package lotto

enum class LottoRank(
    val matchCount: Int,
    private val winningPrice: Price,
) {
    FIRST(6, Price(2_000_000_000)),
    SECOND(5, Price(30_000_000)),
    THIRD(5, Price(1_500_000)),
    FOURTH(4, Price(50_000)),
    FIFTH(3, Price(5_000)),
    SIXTH(2, Price(0)),
    SEVENTH(1, Price(0)),
    NONE(0, Price(0)),
    ;

    fun sumPrice(count: Count): Int {
        return winningPrice.value * count.value
    }

    fun getPriceValue(): Int {
        return winningPrice.value
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