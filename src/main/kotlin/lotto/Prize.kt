package lotto

enum class Prize(val sameCounts: List<Int>, val amount: Amount) {
    NONE_PRIZE(listOf(0, 1, 2), Amount(0)),
    FOURTH_PRIZE(listOf(3), Amount(5_000)),
    THIRD_PRIZE(listOf(4), Amount(50_000)),
    SECOND_PRIZE(listOf(5), Amount(1_500_000)),
    FIRST_PRIZE(listOf(6), Amount(2_000_000_000));

    companion object {

        fun fromSameCount(count: Int): Prize {
            return values().find { it.sameCounts.contains(count) } ?: throw IllegalArgumentException("해당하는 등수가 없습니다.")
        }
    }
}
