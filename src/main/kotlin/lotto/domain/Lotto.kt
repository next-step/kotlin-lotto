package lotto.domain

class Lotto(val numbers: List<Int>) {

    constructor(randomNumberGenerator: RandomNumberGenerator) :
        this(randomNumberGenerator.getRandomNumbers(LOTTO_NUMBER_RANGE, LOTTO_NUMBER_COUNT))

    init {
        require(numbers.all { LOTTO_NUMBER_RANGE.contains(it) })
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

    fun toString(delimiter: String, prefix: String = "", postfix: String = ""): String {
        return numbers.joinToString(delimiter, prefix, postfix)
    }

    companion object {
        val LOTTO_NUMBER_RANGE = 1..45
        const val LOTTO_NUMBER_COUNT = 6
    }
}
