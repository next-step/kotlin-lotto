package org.bmsk.domain.model.lotto

data class LottoLottery(
    val numbers: Set<LottoNumber>,
) {
    constructor(numbers: List<LottoNumber>) : this(numbers.toSet())

    init {
        require(numbers.size == LOTTO_NUMBER_SIZE)
        require(numbers.distinct().size == LOTTO_NUMBER_SIZE)
    }

    fun sortedNumbers(): List<LottoNumber> = numbers.sortedBy { it.number }
    fun contains(number: LottoNumber): Boolean = numbers.contains(number)
    fun contains(number: Int): Boolean = contains(LottoNumber(number))

    companion object {
        const val DEFAULT_PRICE = 1000
        const val LOTTO_NUMBER_SIZE = 6
    }
}
