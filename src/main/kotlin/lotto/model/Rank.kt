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
            """코드적으로는 First 검사 >> Second, Third .. 순서로 검사하는게 자연스럽고 깔끔하게 짤수 있을꺼같은데요,
            로또의 대부분의 경우는 Boom(꽝) 이기 때문에 대부분의 케이스를 early reautrn 해주고 싶어서 이렇게 작성하였습니다.
            혹시 성능적인 관점에서 큰 차이가 없을꺼같긴 한데 코드 깔끔함 VS 예상되는 동작 둘중에 어떤걸 선택하는게 좋을까요??"""
            return when {
                isBoom(matchCount) -> BOOM
                isSecond(matchCount, bonus) -> SECOND
                isThird(matchCount, bonus) -> THIRD
                else -> countToRank(matchCount)
            }
        }

        private fun isBoom(matchCount: Int): Boolean {
            return matchCount in (0..BOOM.matchCount)
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
