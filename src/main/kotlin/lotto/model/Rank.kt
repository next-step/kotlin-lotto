package lotto.model

enum class Rank(
    private val matchCount: Int,
    private val isRequireBonus: Boolean,
    private val prize: Int,
) {
    FIRST(6, false, 2_000_000_000),
    SECOND(5, true, 30_000_000),
    THIRD(5, false, 1_500_000),
    FOURTH(4, false, 50_000),
    FIFTH(3, false, 5_000),
    BOOM(2, false, 0), ;

    fun totalPrizeOf(count: Int): Int {
        return this.prize * count
    }

    companion object {
        fun of(matchCount: Int, bonus: Boolean): Rank {
            if (isBoom(matchCount)) {
                return BOOM
            }
            if (isSecond(matchCount, bonus)) {
                return SECOND
            }
            if (isThird(matchCount, bonus)) {
                return THIRD
            }
            return countToRank(matchCount)
        }

        private fun isBoom(matchCount: Int): Boolean {
            return matchCount <= BOOM.matchCount
        }

        private fun isThird(matchCount: Int, bonus: Boolean): Boolean {
            return isConditionOfRank(matchCount, bonus, THIRD)
        }

        private fun isSecond(matchCount: Int, bonus: Boolean): Boolean {
            return isConditionOfRank(matchCount, bonus, SECOND)
        }

        private fun isConditionOfRank(matchCount: Int, bonus: Boolean, rank: Rank): Boolean {
            return ((matchCount == rank.matchCount) && (bonus == rank.isRequireBonus))
        }

        private fun countToRank(count: Int): Rank {
            return requireNotNull(
                Rank.values().firstOrNull { (it.matchCount == count) }
            ) { "입력된 당첨번호의 갯수 [$count] 는 로또의 등수로 변환할 수 없습니다" }
        }
    }
}
