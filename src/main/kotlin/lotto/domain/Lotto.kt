package lotto.domain

typealias Numbers = Set<Int>

class Lotto {

    val numbers: Numbers

    constructor(numbers: Set<Int>) {
        this.numbers = numbers
    }

    fun countWinningNumber(winningNumber: Numbers) {
        val winningCount = numbers.filter {
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
