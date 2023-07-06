package lotto.domain

import lotto.view.ExceptionMessage

open class Lotto(
    val numbers: Set<LottoNumber>
) {
    init {
        require(numbers.size == 6) { ExceptionMessage.DUPLICATE_NUMBER_OR_NOT_SIX.message }
    }

    constructor(numbers: List<LottoNumber>) : this(numbers.map { it }.toSet())

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Lotto

        return numbers.containsAll(other.numbers)
    }

    override fun hashCode(): Int {
        return numbers.hashCode()
    }
}
