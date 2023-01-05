package lotto.domain

enum class RANKING(val winningCount: Int, val winningPrice: Int, val checkBonus: Boolean, val bonusMatched: Boolean) {
    MISS(0, 0, false, false),
    FIFTH(3, 5_000, false, false),
    FOURTH(4, 50_000, false, false),
    THIRD(5, 1_500_000, true, false),
    SECOND(5, 30_000_000, true, true),
    FIRST(6, 2_000_000_000, false, false);

    companion object {
        fun countOf(winningCount: Int, bonusMatched: Boolean): RANKING {
            return values().find {
                if (it.checkBonus) {
                    it.winningCount == winningCount && it.bonusMatched == bonusMatched
                } else {
                    it.winningCount == winningCount
                }
            } ?: MISS
        }
    }
}
