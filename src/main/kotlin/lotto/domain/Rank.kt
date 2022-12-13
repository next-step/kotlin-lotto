package lotto.domain

enum class Rank(val count: Int, val amount: Long, private val isBonus: Boolean) {
    MISS(0, 0, false),
    FIFTH(3, 5_000, false),
    FOURTH(4, 50_000, false),
    THIRD(5, 1_500_000, false),
    SECOND(5, 30_000_000, true),
    FIRST(6, 2_000_000_000, false);

    fun correspond(count: Int, isBonus: Boolean): Boolean {
        return this.count == count && this.isBonus == isBonus
    }

    companion object {
        fun match(count: Int, isBonus: Boolean): Rank {
            return Rank.values().find {
                it.correspond(count, isBonus)
            } ?: MISS
        }
    }
}