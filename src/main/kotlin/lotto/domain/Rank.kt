package lotto.domain

enum class Rank(val count: Int, private val hasBonus: Boolean, val reward: Int) {
    FIRST(6, false, 2000000000),
    SECOND(5, true, 30000000),
    THIRD(5, false, 1500000),
    FOURTH(4, false, 50000),
    FIFTH(3, false, 5000),
    NONE(0, false, 0);

    companion object {
        fun getValue(count: Int, hasBonus: Boolean): Rank {
            return Rank.values().firstOrNull { it.count == count && it.hasBonus == hasBonus } ?: NONE
        }
    }
}
