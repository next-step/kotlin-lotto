package lotto.domain

enum class LottoRank(val matchCount: Int, val winningMoney: Int, val matchBonus: Boolean) {
    FIRST_PLACE(matchCount = 6, winningMoney = 2_000_000_000, matchBonus = false),
    SECOND_PLACE(matchCount = 5, winningMoney = 30_000_000, matchBonus = true),
    THIRD_PLACE(matchCount = 5, winningMoney = 1_500_000, matchBonus = false),
    FORTH_PLACE(matchCount = 4, winningMoney = 50_000, matchBonus = false),
    FIFTH_PLACE(matchCount = 3, winningMoney = 5_000, matchBonus = false);

    override fun toString(): String {
        return "${matchCount}개 일치${if (matchBonus) ", 보너스 볼 일치" else " "}($winningMoney)"
    }

    companion object {
        fun selectByMatchCount(matchCount: Int, matchBonus: Boolean): LottoRank? {
            if (matchCount == 5) {
                return values().find { it.matchCount == matchCount && it.matchBonus == matchBonus }
            }
            return values().find { it.matchCount == matchCount }
        }
    }
}
