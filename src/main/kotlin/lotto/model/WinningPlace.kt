package lotto.model

enum class WinningPlace(val price: Money, val count: Int, val bonusExist: Boolean) {
    FIRST(Money(2_000_000_000), 6, false),
    SECOND(Money(30_000_000), 5, true),
    THIRD(Money(1_500_000), 5, false),
    FOURTH(Money(50_000), 4, false),
    FIFTH(Money(5_000), 3, false),
    MISS(Money(0), 0, false);

    companion object {
        fun match(winningCount: Int, bonusExist: Boolean): WinningPlace {
            val candidates = values().filter {
                it.count == winningCount
            }

            if (isSecondOrThird(candidates)) {
                return candidates.last { it.bonusExist == bonusExist }
            }

            if (candidates.isEmpty()) {
                return MISS
            }

            return candidates.first()
        }

        private fun isSecondOrThird(candidates: List<WinningPlace>): Boolean {
            return candidates.containsAll(listOf(SECOND, THIRD))
        }
    }
}
