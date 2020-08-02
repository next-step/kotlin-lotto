package lotto.domain

class Lotto() {

    var numbers = listOf<Int>()
    var winningCount = 0

    constructor(numbers: List<Int>) : this() {
        this.numbers = numbers
    }

    fun countWinningNumber(winningNumber: List<Int>) {
        winningCount = numbers.filter {
            winningNumber.contains(it)
        }.count()
    }

    companion object {
        fun of(): Lotto {
            return Lotto(
                IntRange(1, 45)
                    .shuffled()
                    .take(6)
                    .sorted()
            )
        }
    }
}
