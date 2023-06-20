package lotto.domain

enum class LottoResult(val winningAmount: Int, val matchCount: Int, val checkBonus: Boolean) {

    FIRST_PLACE(2000000000, 6, false),
    SECOND_PLACE(30000000, 5, true),
    THIRD_PLACE(1500000, 5, false),
    FOURTH_PLACE(50000, 4, false),
    FIFTH_PLACE(5000, 3, false),
    LOSE(0, 0, false);

    private fun checkBonus(matchBonus: Boolean): Boolean = if (this.checkBonus) matchBonus else true

    companion object {
        fun lottoResult(matchCount: Int, matchBonus: Boolean): LottoResult {
            return values().find { it.matchCount == matchCount && it.checkBonus(matchBonus) } ?: LOSE
        }
    }
}
