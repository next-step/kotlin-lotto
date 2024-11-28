package lotto

enum class LottoRank(
    val matchCount: Int,
    private val winningPrice: Price,
) {
    FIRST(6, Price(2_000_000_000)),
    SECOND(5, Price(1_500_000)),
    THIRD(4, Price(50_000)),
    FOURTH(3, Price(5_000)),
    FIFTH(2, Price(0)),
    SIXTH(1, Price(0)),
    NONE(0, Price(0)),
    ;

    fun sumPrice(count: Int): Int {
        return winningPrice.value * count
    }

    fun getPriceValue(): Int {
        return winningPrice.value
    }

    companion object {
        fun valueOf(matchCount: Int): LottoRank {
            return entries.find { it.matchCount == matchCount } ?: NONE
        }
    }
}
