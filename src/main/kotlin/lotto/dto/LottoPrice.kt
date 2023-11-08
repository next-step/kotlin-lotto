package lotto.dto

enum class LottoPrice(val matchedCount: Int, val price: Int, val text: String) {
    NOT_MATCHED(0, 0, "0개 일치"),
    ONE_MATCHED(1, 0, "1개 일치"),
    TWO_MATCHED(2, 0, "2개 일치"),
    THREE_MATCHED(3, 5_000, "3개 일치"),
    FOUR_MATCHED(4, 50_000, "4개 일치"),
    FIVE_MATCHED(5, 1_500_000, "5개 일치"),
    FIVE_MATCHED_WITH_BONUS(5, 30_000_000, "5개 일치, 보너스 볼 일치"),
    ALL_MATCHED(6, 2_000_000_000, "6개 일치");

    companion object {
        fun from(matchedCount: Int) = values().find { it.matchedCount == matchedCount } ?: NOT_MATCHED

        fun rankOf() = values().filter { it.price != 0 }.sortedBy { it.matchedCount }.toList()
    }
}
