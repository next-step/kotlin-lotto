package lotto

enum class Prize(val sameCount: Int, val amount: Amount) {
    FOURTH_PRIZE(3, Amount(5_000)),
    THIRD_PRIZE(4, Amount(50_000)),
    SECOND_PRIZE(5, Amount(1_500_000)),
    FIRST_PRIZE(6, Amount(2_000_000_000)),
}
