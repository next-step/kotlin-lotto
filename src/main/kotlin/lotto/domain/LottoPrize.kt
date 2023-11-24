package lotto.domain

enum class LottoPrize(val matchCount: Int, val prizeMoney: Int, val text: String) {
    MISS(0, 0, "0개 일치"),
    FIFTH(3, 5_000, "3개 일치"),
    FOURTH(4, 50_000, "4개 일치"),
    THIRD(5, 1_500_000, "5개 일치"),
    SECOND(5, 30_000_000, "5개 일치, 보너스 볼 일치"),
    FIRST(6, 2_000_000_000, "6개 일치");

    companion object {
        fun from(matchCount: Int) = values().find { it.matchCount == matchCount } ?: MISS

        fun rankOf() = values().filter { it.prizeMoney != 0 }.sortedBy { it.matchCount }.toList()

    }
}
