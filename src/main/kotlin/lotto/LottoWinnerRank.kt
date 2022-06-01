package lotto

enum class LottoWinnerRank(val price: Int, val matchCount: Int, private val needBonusNumber: Boolean) {
    FIRST_PRICE(2_000_000_000, 6, false),
    SECOND_PRICE(30_000_000, 5, true),
    THIRD_PRICE(1_500_000, 5, false),
    FOURTH_PRICE(50_000, 4, false),
    FIFTH_PRICE(5_000, 3, false),
    NONE(0, -1, false),
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
