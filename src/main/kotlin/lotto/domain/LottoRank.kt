package lotto.domain

enum class LottoRank(val matchCount: Int, val winningAmount: Int, val isMatch: (Int, Boolean) -> Boolean) {
    FIRST(6, 2_000_000_000, { matchCount, _ -> matchCount == 6 }),
    SECOND(5, 30_000_000, { matchCount, matchBonus -> matchCount == 5 && matchBonus }),
    THIRD(5, 1_500_000, { matchCount, matchBonus -> matchCount == 5 && !matchBonus }),
    FOURTH(4, 50_000, { matchCount, _ -> matchCount == 4 }),
    FIFTH(3, 5_000, { matchCount, _ -> matchCount == 3 }),
    NONE(0, 0, { _, _ -> true });

    companion object {
        fun of(matchCount: Int, matchBonus: Boolean): LottoRank = entries.first { it.isMatch(matchCount, matchBonus) }
    }
}
