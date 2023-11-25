package lotto.domain

enum class LottoPrize(val matchCount: Int, val prizeMoney: Int, val isMatchBonus: Boolean, val text: String) {
    MISS(0, 0, false,  "0개 일치"),
    FIFTH(3, 5_000, false, "3개 일치"),
    FOURTH(4, 50_000, false,"4개 일치"),
    THIRD(5, 1_500_000, false, "5개 일치"),
    SECOND(5, 30_000_000, true,"5개 일치, 보너스 볼 일치"),
    FIRST(6, 2_000_000_000, false,"6개 일치");

    companion object {
        fun from(matchCount: Int, matchBonus : Boolean) = values().find { it.matchCount == matchCount && it.isMatchBonus == matchBonus } ?: MISS

        fun rankOf() = values().filter { it.prizeMoney != 0 }.sortedBy { it.matchCount }.toList()

    }
}
