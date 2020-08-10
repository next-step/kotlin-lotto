package lotto.domain

enum class Rank(val countOfMatch: Int, val winningMoney: Money, val matchBonus: Boolean = false) {
    FIRST(6, Money(2_000_000_000)),
    SECOND(5, Money(30_000_000), true),
    THIRD(5, Money(1_500_000)),
    FOURTH(4, Money(50_000)),
    FIFTH(3, Money(5_000)),
    MISS(0, Money(0));

    fun prizeByCount(count: Int): Money = winningMoney * count

    companion object {
        fun rank(countOfMatch: Int, matchBonus: Boolean = false): Rank {
            return values().find { it.countOfMatch == countOfMatch && it.matchBonus == matchBonus } ?: MISS
        }
    }
}
