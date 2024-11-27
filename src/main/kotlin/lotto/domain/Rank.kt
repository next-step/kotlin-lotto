package lotto.domain

enum class Rank(
    val countOfMatch: Int,
    val isMatchBonusNeed: Boolean,
    val winningMoney: Int,
) {
    FIRST(6, false, 2_000_000_000),
    SECOND(5, true, 30_000_000),
    THIRD(5, false, 1_500_000),
    FOURTH(4, false, 50_000),
    FIFTH(3, false, 5_000),
    MISS(0, false, 0), ;

    companion object {
        fun getRankCount(
            rank: Rank,
            lottos: Lottos,
            winningNumbers: WinningNumbers,
        ): Int {
            val ranks =
                lottos.lottos.map {
                    valueOf(
                        winningNumbers.matchNumbers(it),
                        it.numbers.lottoNumbers.map { lottoNumber -> lottoNumber.number }
                            .contains(winningNumbers.bonusnumber.number),
                    )
                }
            return ranks.filter { it.equals(rank) }.size
        }

        private fun valueOf(
            countOfMatch: Int,
            matchBonus: Boolean,
        ): Rank {
            if (!matchBonus) {
                return entries.find { it.countOfMatch == countOfMatch && !it.isMatchBonusNeed } ?: MISS
            }
            val bonusMatchRank = entries.find { it.countOfMatch == countOfMatch && it.isMatchBonusNeed }
            if (bonusMatchRank != null) {
                return bonusMatchRank
            }
            return entries.find { it.countOfMatch == countOfMatch } ?: MISS
        }
    }
}
