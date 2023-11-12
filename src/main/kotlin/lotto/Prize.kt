package lotto

enum class Prize(val sameCount: Int, val amount: Amount) {
    NONE_PRIZE(0, Amount(0)),
    FOURTH_PRIZE(3, Amount(5_000)),
    THIRD_PRIZE(4, Amount(50_000)),
    SECOND_PRIZE(5, Amount(1_500_000)),
    FIRST_PRIZE(6, Amount(2_000_000_000));

    companion object Something {
        private val orderedPrize = values().toList().sortedByDescending { it.sameCount }

        fun fromSameCount(count: Int): Prize {
            require(FIRST_PRIZE.sameCount >= count) { "최대 일치 수를 초과했습니다." }
            return orderedPrize.find { it.sameCount <= count } ?: throw IllegalArgumentException("최소 일치 수를 미달했습니다.")
        }
    }
}
