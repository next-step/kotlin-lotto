package lotto.domain

class Lotto() {

    var numbers = listOf<Int>()

    constructor(numbers: List<Int>) : this() {
        this.numbers = numbers
    }

    companion object {
        fun of(): Lotto {
            return Lotto(
                IntRange(1, 45)
                    .shuffled()
                    .take(5)
                    .sorted()
            )
        }
    }
}
