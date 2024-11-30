package lotto.domain

class Lotto(private val numbers: Set<Int>) {
    init {
        validateLottoNumberCount()
        validateLottoNumber()
    }

    private fun validateLottoNumberCount() {
        if (isInvalidCount(numbers)) {
            throw InvalidLottoNumberCountException(numbers)
        }
    }

    private fun isInvalidCount(numbers: Set<Int>) = numbers.size != NUMBER_COUNT

    private fun validateLottoNumber() {
        val invalidNumberCount =
            numbers.count { number ->
                number < MIN_LOTTO_NUMBER || number > MAX_LOTTO_NUMBER
            }

        if (invalidNumberCount != 0) {
            throw InvalidLottoNumberException(numbers)
        }
    }

    fun calculateMatchCount(other: Lotto): Int {
        return numbers.count { number -> other.contains(number) }
    }

    private fun contains(number: Int): Boolean {
        return number in numbers
    }

    override fun toString(): String {
        return numbers.toString()
    }

    companion object {
        const val MIN_LOTTO_NUMBER = 1
        const val MAX_LOTTO_NUMBER = 45
        const val NUMBER_COUNT = 6
        const val MIN_AMOUNT_UNIT = 1000
    }
}
