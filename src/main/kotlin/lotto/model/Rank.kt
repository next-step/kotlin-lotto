package lotto.model

enum class Rank(
    val matchCount: Int,
    val isRequireBonus: Boolean,
    val prize: Int,
) {
    FIRST(6, false, 2_000_000_000),
    SECOND(5, true, 222222222),
    THIRD(5, false, 1_500_000),
    FOURTH(4, false, 50_000),
    FIFTH(3, false, 5_000),
    BOOM(2, false, 0), ;

    fun totalPrizeOf(count: Int): Int {
        return this.prize * count
    }

    companion object {
        fun matchCountToRank(matchCount: Int, bouns: Boolean): Rank {
            if (matchCount < 3) {
                return BOOM
            }
            if (matchCount == 3) {
                return FIFTH
            }
            if (matchCount == 4) {
                return FOURTH
            }
            if (matchCount == 5 && !bouns) {
                return THIRD
            }
            if (matchCount == 5) {
                return SECOND
            }
            if (matchCount == 6) {
                return FIRST
            }
            throw IllegalArgumentException("잘못된 값이 입력 되었습니다")
        }
    }
}
