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

        val byMatch = PrizeGenerator.findByMatch(winningCount, isMatchedBonusNumber(winningLotto.bonusNumber))
        byMatch.countRank()
    }

    private fun isMatchedBonusNumber(bonusNumber: Int): Boolean {
        return numbers.contains(bonusNumber)
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
