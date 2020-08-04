package lotto.domain

typealias Numbers = Set<Int>

class Lotto {

    val numbers: Numbers
    var winningCount = 0

    constructor(numbers: Set<Int>) {
        this.numbers = numbers
    }

    fun countWinningNumber(winningNumber: Numbers) {
        winningCount = numbers.filter {
            winningNumber.contains(it)
        }.count()

        Statistics.countRank(winningCount)
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
