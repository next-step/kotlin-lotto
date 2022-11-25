package lotto.domain

enum class Award(
    val prize: Long,
    val matchCount: Int,
) {
    NON_PLACE(0, 0),
    FIFTH_PLACE(5_000, 3),
    FOURTH_PLACE(50_000, 4),
    THIRD_PLACE(1_500_000, 5),
    FIRST_PLACE(2_000_000_000, 6);

    companion object {
        fun of(matchCount: Int): Award {
            return values().find { it.matchCount == matchCount } ?: NON_PLACE
        }
    }
}
