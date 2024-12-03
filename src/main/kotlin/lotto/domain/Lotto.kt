package lotto.domain

class Lotto(private val numbers: Set<LottoNumber>) {
    constructor(vararg numbers: Int) : this(numbers.map { number -> LottoNumber(number) }.toSet())

    init {
        validateLottoNumberCount()
    }

    private fun validateLottoNumberCount() {
        if (isInvalidCount()) {
            throw InvalidLottoNumberCountException(numbers)
        }
    }

    private fun isInvalidCount() = numbers.size != NUMBER_COUNT

    fun calculateMatchCount(other: Lotto): Int {
        return numbers.count { number -> other.contains(number) }
    }

    private fun contains(number: LottoNumber): Boolean {
        return number in numbers
    }

    override fun toString(): String {
        return numbers.toString()
    }

    companion object {
        const val NUMBER_COUNT = 6
        const val MIN_AMOUNT_UNIT = 1000
    }
}
