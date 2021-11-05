package lotto.domain

private val DONT_CARE: Boolean? = null

enum class LottoRanking(val count: Int, val bonus: Boolean?, val reward: Long) {
    RANK_1(6, DONT_CARE, 2_000_000_000L),
    RANK_2(5, true, 30_000_000L),
    RANK_3(5, false, 15_00_000L),
    RANK_4(4, DONT_CARE, 50_000L),
    RANK_5(3, DONT_CARE, 5_000L),
    NO_RANK(-1, DONT_CARE, 0)
    ;

    private fun isCountMatch(count: Int) = (this.count == count)

    private fun isBonusMatch(bonus: Boolean): Boolean {
        return if (this.bonus == DONT_CARE) {
            true
        } else {
            this.bonus == bonus
        }
    }

    companion object {

        fun from(count: Int, bonus: Boolean): LottoRanking {
            return values().firstOrNull {
                it.isCountMatch(count) && it.isBonusMatch(bonus)
            } ?: NO_RANK
        }
    }
}
