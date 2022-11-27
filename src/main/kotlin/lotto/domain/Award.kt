package lotto.domain

private const val WITH_OF_BONUS_COUNT = 5

enum class Award(
    val prize: Long,
    val matchCount: Int,
) {
    NON_PLACE(0, 0),
    FIFTH_PLACE(5_000, 3),
    FOURTH_PLACE(50_000, 4),
    THIRD_PLACE(1_500_000, WITH_OF_BONUS_COUNT),
    SECOND_PLACE(30_000_000, WITH_OF_BONUS_COUNT),
    FIRST_PLACE(2_000_000_000, 6);

    companion object {
        fun of(matchCount: Int, matchBonus: Boolean): Award {
            if (matchCount == WITH_OF_BONUS_COUNT) {
                return getPlaceWithBonus(matchBonus)
            }

            return values()
                .find { it.matchCount == matchCount } ?: NON_PLACE
        }

        private fun getPlaceWithBonus(matchBonus: Boolean): Award = if (matchBonus) {
            SECOND_PLACE
        } else {
            THIRD_PLACE
        }
    }
}
