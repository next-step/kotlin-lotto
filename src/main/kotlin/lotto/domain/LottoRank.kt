package lotto.domain

enum class LottoRank(val winningMoney: Amount, val countOfMatch: Int, val isWithBonusMatch: Boolean = false) {
    FIRST(Amount(2_000_000_000), 6),
    SECOND(Amount(30_000_000), 5, true),
    THIRD(Amount(1_500_000), 5),
    FOURTH(Amount(50_000), 4),
    FIFTH(Amount(5_000), 3),
    MISS(Amount(0), 0);

    companion object {
        fun valueOf(countOfMatch: Int, hasMatchedBonus: Boolean): LottoRank =
            entries.firstOrNull { isMatchedRank(it, countOfMatch, hasMatchedBonus) } ?: MISS

        private fun isMatchedRank(rank: LottoRank, countOfMatch: Int, matchBonus: Boolean): Boolean {
            if (rank.countOfMatch != countOfMatch) return false
            if (rank.isWithBonusMatch) return matchBonus
            return true
        }
    }
}
