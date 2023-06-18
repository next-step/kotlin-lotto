package lotto.enums

enum class Winner(
    reward: Int,
    matchCount: Int
) {
    FIRST_PLACE(2_000_000_000, 6),
    SECOND_PLACE(1_500_000, 5),
    THIRD_PLACE(50_000, 4),
    FOURTH_PLACE(5_000, 3)
}