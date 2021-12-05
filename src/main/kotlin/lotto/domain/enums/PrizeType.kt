package lotto.domain.enums

enum class PrizeType(
    val match: Int,
    val money: Int
) {
    FIRST_PLACE(6, 2_000_000_000),
    SECOND_PLACE(5, 30_000_000),
    THIRD_PLACE(5, 1_500_000),
    FOURTH_PLACE(4, 50_000),
    FIFTH_PLACE(3, 5_000),
    OTHER_PLACE(0, 0);

    companion object {

        private const val SECOND_AND_THIRD_PLACE_MATCH_COUNT = 5

        fun findPrize(match: Int, bonusMatch: Boolean): PrizeType {
            return when (match) {
                SECOND_AND_THIRD_PLACE_MATCH_COUNT -> isBonus(bonusMatch)
                else -> values()
                    .find { it.match == match } ?: OTHER_PLACE
            }
        }

        fun isBonus(bonusMatch: Boolean): PrizeType {
            if (bonusMatch)
                return SECOND_PLACE

            return THIRD_PLACE
        }
    }
}
