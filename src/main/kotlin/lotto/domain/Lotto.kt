package lotto.domain

class Lotto {

    val numbers: Set<Int>
    var winningCount = 0

    constructor(numbers: Set<Int>) {
        this.numbers = numbers
    }

    fun countWinningNumber(winningNumber: List<Int>) {
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
