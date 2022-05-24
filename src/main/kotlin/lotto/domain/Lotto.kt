package lotto.domain

class Lotto {
    private val numbers: List<Int>

    constructor(randomNumberGenerator: RandomNumberGenerator) {
        numbers = randomNumberGenerator.getRandomNumbers(LOTTO_NUMBER_RANGE, LOTTO_NUMBER_COUNT)
    }

    constructor(numbers: List<Int>) {
        this.numbers = numbers
    }

    fun contains(number: Int): Boolean {
        return numbers.contains(number)
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Lotto

        if (numbers != other.numbers) return false

        return true
    }

    override fun hashCode(): Int {
        return numbers.hashCode()
    }

    companion object {
        val LOTTO_NUMBER_RANGE = 1..45
        const val LOTTO_NUMBER_COUNT = 6
    }
}
