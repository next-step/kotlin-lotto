package lotto.domain

typealias Numbers = Set<Int>

class Lotto {

    val numbers: Numbers

    constructor(numbers: Set<Int>) {
        this.numbers = numbers
    }

    fun countWinningNumber(winningLotto: WinningLotto) {
        val winningCount = numbers.filter {
            winningLotto.winningNumbers.contains(it)
        }.count()

        when (winningCount) {
            PrizeGenerator.THREE_MATCH.matched -> PrizeGenerator.THREE_MATCH.countRank()
            PrizeGenerator.FOUR_MATCH.matched -> PrizeGenerator.FOUR_MATCH.countRank()
            PrizeGenerator.FIVE_MATCH.matched -> {
                if (isMatchedBonusNumber(winningCount, winningLotto.bonusNumber)) {
                    PrizeGenerator.BONUS_MATCH.countRank()
                } else {
                    PrizeGenerator.FIVE_MATCH.countRank()
                }
            }
            PrizeGenerator.SIX_MATCH.matched -> PrizeGenerator.SIX_MATCH.countRank()
        }
    }

    private fun isMatchedBonusNumber(winningCount: Int, bonusNumber: Int): Boolean {
        return (winningCount == PrizeGenerator.FIVE_MATCH.matched) && (numbers.contains(bonusNumber))
    }

    companion object {
        fun of(): Lotto {
            return Lotto(
                IntRange(1, 45)
                    .shuffled()
                    .take(6)
                    .sorted()
                    .toSet()
            )
        }
    }
}
