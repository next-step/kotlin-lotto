package lotto.domain

class LottoNumbers(private val numbers: Set<LottoNumber>) : Collection<LottoNumber> by numbers {
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

    companion object {
        const val NUMBER_COUNT = 6
    }
}
