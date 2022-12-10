package lotto.domain.model

enum class Rank(val matchCount: Int, val prize: Int) {
    FIRST_GRADE(6, 2_000_000_000),
    SECOND_GRADE(5, 30_000_000),
    THIRD_GRADE(5, 1_500_000),
    FOURTH_GRADE(4, 50_000),
    FIFTH_GRADE(3, 5_000),
    NO_MATCH(0, 0);

    companion object {

        fun safeValueOf(matchCount: Int, matchBonus: Boolean): Rank {
            if (matchBonus && matchCount == 5) {
                return SECOND_GRADE
            }

            return values().find { rank ->
                rank.matchCount == matchCount
            } ?: NO_MATCH
        }

        fun countMatchNumber(winningNumbers: WinningNumbers, lottoNumbers: List<Int>): Int {
            return winningNumbers.numbers.sumOf { winningNumber ->
                checkContainWinningNumber(winningNumber, lottoNumbers)
            }
        }

        fun matchingWinner(matchCount: Int, matchBonus: Boolean): Rank {
            check((Lotto.START_LOTTO_INDEX..Lotto.LAST_LOTTO_INDEX).contains(matchCount)) { "당첨 개수는 최대 6개 최소 0개 입니다" }
            return Rank.safeValueOf(matchCount = matchCount, matchBonus = matchBonus)
        }

        fun win(winningNumbers: WinningNumbers, lottoNumbers: List<Int>, bonusNumber: Int = 0): Rank {
            val matchCount: Int = Rank.countMatchNumber(winningNumbers, lottoNumbers)
            val matchBonus: Boolean = matchBonus(matchCount, lottoNumbers, bonusNumber)
            return Rank.matchingWinner(matchCount, matchBonus)
        }

        private fun matchBonus(matchCount: Int, lottoNumbers: List<Int>, bonusNumber: Int): Boolean {
            return matchCount == 5 && lottoNumbers.contains(bonusNumber)
        }

        private fun checkContainWinningNumber(winningNumber: Int, lottoNumbers: List<Int>): Int {
            return if (lottoNumbers.contains(winningNumber)) 1 else 0
        }
    }
}
