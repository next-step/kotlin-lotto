package lotto.model

enum class LottoPlace(val winnings: Money, val winningCount: Int, val bonusCount: Int) {
    FIRST(Money(2_000_000_000), 6, 0),
    SECOND(Money(30_000_000), 5, 1),
    THIRD(Money(1_500_000), 5, 0),
    FOURTH(Money(50_000), 4, 0),
    FIFTH(Money(5_000), 3, 0),
    MISS(Money(0), 0, 0);

    companion object {
        fun match(winningCount: Int, bonusCount: Int): LottoPlace {
            val candidates = values().filter {
                it.winningCount == winningCount
            }

            if (isSecondOrThird(candidates)) {
                return candidates.last { it.bonusCount == bonusCount }
            }

            if (candidates.isEmpty()) {
                return MISS
            }

            return candidates.first()
        }

        private fun isSecondOrThird(candidates: List<LottoPlace>) = candidates.size == 2
    }
}
