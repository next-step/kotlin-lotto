package lotto.enums

enum class Rank(
    val matchCount: Int,
    val reward: Int,
) {
    FOURTH_RANK(3, 5_000),
    THIRD_RANK(4, 50_000),
    SECOND_RANK(5, 1_500_000),
    SECOND_BONUS_RANK(5, 3_000_000),
    FIRST_RANK(6, 2_000_000_000),
    NONE_RANK(0, 0),
    ;

    companion object {

        fun valueOf(count: Int, matchBonus: Boolean): Rank {
            val rank = values().find {
                it.matchCount == count
            } ?: Rank.NONE_RANK

            if (rank == SECOND_RANK && matchBonus) {
                return Rank.SECOND_BONUS_RANK
            }
            return rank
        }
    }
}
