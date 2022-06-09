package lotto.domain

enum class Rank(val prize: Double) {
    FIRST(Rank.PRIZE_1ST),
    SECOND(Rank.PRIZE_2ND),
    THIRD(Rank.PRIZE_3RD),
    FOURTH(Rank.PRIZE_4TH),
    LOSE(Rank.PRIZE_LOSER);

    companion object {
        fun of(matched: Int): Rank {
            return when (matched) {
                6 -> FIRST
                5 -> SECOND
                4 -> THIRD
                3 -> FOURTH
                else -> LOSE
            }
        }

        private const val PRIZE_1ST = 2_000_000_000.0
        private const val PRIZE_2ND = 1_500_000.0
        private const val PRIZE_3RD = 50_000.0
        private const val PRIZE_4TH = 5_000.0
        private const val PRIZE_LOSER = 0.0
    }
}
