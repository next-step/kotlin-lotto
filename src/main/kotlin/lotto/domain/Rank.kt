package lotto.domain

/**
 *
 * @author Leo
 */
enum class Rank(val prize: Int, val sameCount: Int, val bonus: Boolean = false) {

    FIRST(2000000000, 6),
    SECOND(30000000, 5, true),
    THIRD(1500000, 5),
    FOURTH(50000, 4),
    FIFTH(5000, 3),
    NONE(0, 0);

    companion object {
        fun rank(sameNumbers: List<Int>, isBonusWin: Boolean): Rank? {
            return when (sameNumbers.size) {
                RANK_SECOND_COUNT -> getRankWithBonus(isBonusWin)
                else -> values().firstOrNull { it.sameCount == sameNumbers.size }
            }

        }

        private fun getRankWithBonus(isBonusWin: Boolean): Rank {
            if (isBonusWin) {
                return SECOND
            }

            return THIRD
        }

        private const val RANK_SECOND_COUNT = 5
    }

}
