package lotto.domain

enum class Rank(val countOfMatch: Int, val winningMoney: Money, val matchBonus: Boolean = false) {
    MISS(0, Money(0)),
    FIFTH(3, Money(5_000)),
    FOURTH(4, Money(50_000)),
    THIRD(5, Money(1_500_000)),
    SECOND(5, Money(30_000_000), true),
    FIRST(6, Money(2_000_000_000));

    fun prizeByCount(count: Int): Money = winningMoney * count

    override fun toString(): String {
        return "${countOfMatch}$COUNT_SUFFIX ($winningMoney)"
    }

    companion object {
        private const val COUNT_SUFFIX = "개 일치"
        fun rank(countOfMatch: Int, matchBonus: Boolean = false): Rank {
            return values().find { it.countOfMatch == countOfMatch && it.matchBonus == matchBonus } ?: MISS
        }
        fun asList() = values().filter { it != MISS }
    }
}
