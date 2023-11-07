package study.lotto.domain

class Lotto private constructor(val numbers: List<Int>) {

    init {
        require(numbers.size == LOTTO_NUMBERS_COUNT) {
            "A Lotto must have exactly 6 numbers, but got ${numbers.size}"
        }
        require(numbers.all { it in START_NUMBER..LAST_NUMBER }) {
            "Lotto numbers must be in the range 1 to 45"
        }
    }

    fun countMatches(winningNumbers: Lotto): Int {
        return this.numbers.count(winningNumbers.numbers::contains)
    }

    companion object {
        const val START_NUMBER = 1
        const val LAST_NUMBER = 45
        const val LOTTO_NUMBERS_COUNT = 6
        const val PRICE_PER_TICKET = 1_000

        fun generate(): Lotto {
            return (START_NUMBER..LAST_NUMBER)
                .shuffled()
                .take(6)
                .sorted()
                .let(::Lotto)
        }

        fun generate(numbers: List<Int>): Lotto = numbers.sorted().let(::Lotto)
    }
}
