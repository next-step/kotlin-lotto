package lotto.domain.model

class Lotto {
    val numbers: List<Int> = (FIRST_NUMBER..LAST_NUMBER).shuffled().subList(0, NUMBER_COUNT)

    enum class Prize(val matches: Int, val reward: Int) {
        NOTHING(0, 0),
        THREE_MATCH(3, 5_000),
        FOUR_MATCH(4, 50_000),
        FIVE_MATCH(5, 1_500_000),
        FIVE_MATCH_PLUS_BONUS(5, 30_000_000),
        SIX_MATCH(6, 2_000_000_000);

        companion object {
            fun from(selectedBalls: SelectedBalls, lotto: Lotto): Prize {
                val hasBonusBall = lotto.numbers.contains(selectedBalls.bonus)
                val matchCount = lotto.numbers.filter { it in selectedBalls.winningNumbers.balls }.size
                return when (matchCount) {
                    Lotto.Prize.SIX_MATCH.matches -> Lotto.Prize.SIX_MATCH
                    Lotto.Prize.FIVE_MATCH.matches -> if (hasBonusBall) Lotto.Prize.FIVE_MATCH_PLUS_BONUS else Lotto.Prize.FIVE_MATCH
                    Lotto.Prize.FOUR_MATCH.matches -> Lotto.Prize.FOUR_MATCH
                    Lotto.Prize.THREE_MATCH.matches -> Lotto.Prize.THREE_MATCH
                    else -> Lotto.Prize.NOTHING
                }
            }
        }
    }

    companion object {
        private const val FIRST_NUMBER = 1
        private const val LAST_NUMBER = 45
        const val NUMBER_COUNT = 6
        const val PRICE = 1_000

        val prizes = listOf(
            Prize.NOTHING,
            Prize.NOTHING,
            Prize.NOTHING,
            Prize.THREE_MATCH,
            Prize.FOUR_MATCH,
            Prize.FIVE_MATCH,
            Prize.FIVE_MATCH_PLUS_BONUS,
            Prize.SIX_MATCH
        )
    }
}
