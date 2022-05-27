package lotto.domain

enum class Winner(val matchedNumbers: Int, val prizeMonery: Long) {
    MATCHED_THREE_NUMBERS(3, 5_000),
    MATCHED_FOUR_NUMBERS(4, 50_000),
    MATCHED_FIVE_NUMBERS(5, 1_500_000),
    MATCHED_SIX_NUMBERS(6, 2_000_000_000)
}
