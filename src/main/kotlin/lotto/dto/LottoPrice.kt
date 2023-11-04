package lotto.dto

enum class LottoPrice(val matchedCount: Int, val price: Int) {
    NOT_MATCHED(0, 0),
    ONE_MATCHED(1, 0),
    TWO_MATCHED(2, 0),
    THREE_MATCHED(3, 5_000),
    FOUR_MATCHED(4, 50_000),
    FIVE_MATCHED(5, 1_500_000),
    ALL_MATCHED(6, 2_000_000_000);

    companion object {
        fun getPrice(matchedCount: Int) = from(matchedCount).price

        fun from(matchedCount: Int) = values().find { it.matchedCount == matchedCount } ?: NOT_MATCHED
    }
}
