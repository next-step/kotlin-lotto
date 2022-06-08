package lotto

enum class LottoWinnerRank(val price: Int, val matchCount: Int, private val needBonusNumber: Boolean = false) {
    FIRST_PRICE(2_000_000_000, 6),
    SECOND_PRICE(30_000_000, 5, true),
    THIRD_PRICE(1_500_000, 5),
    FOURTH_PRICE(50_000, 4),
    FIFTH_PRICE(5_000, 3),
    NONE(0, -1),
    ;

    companion object {
        fun of(matchNumberCount: Int, existBonus: Boolean): LottoWinnerRank {
            return values()
                .filter { checkBonusNumberCondition(it, existBonus) }
                .firstOrNull() { it.matchCount == matchNumberCount }
                ?: NONE
        }

        fun getRankingList(): List<LottoWinnerRank> {
            return values()
                .filter { it != NONE }
                .sortedBy { it.price }
        }

        private fun checkBonusNumberCondition(it: LottoWinnerRank, existBonus: Boolean): Boolean {
            return if (it.needBonusNumber) existBonus else true
        }
    }
}
