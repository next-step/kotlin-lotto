package lotto.domain

enum class LottoPrize(val prizeMoney: Int, val support: (Int, Boolean) -> Boolean, val text: String) {
    MISS(0, { _, _ -> false }, "0개 일치"),
    FIFTH(5_000, { count, _ -> count == 3 }, "3개 일치"),
    FOURTH(50_000, { count, _ -> count == 4 }, "4개 일치"),
    THIRD(1_500_000, { count, bonus -> (count == 5 && bonus == false) }, "5개 일치"),
    SECOND(30_000_000, { count, bonus -> (count == 5 && bonus) }, "5개 일치, 보너스 볼 일치"),
    FIRST(2_000_000_000, { count, _ -> count == 6 }, "6개 일치");

    companion object {
        fun from(matchCount: Int, matchBonus: Boolean) = values().find { it.support(matchCount, matchBonus) } ?: MISS
        fun rankOf() = values().filter { it.prizeMoney != 0 }.sortedBy { it.prizeMoney }.toList()
    }
}
