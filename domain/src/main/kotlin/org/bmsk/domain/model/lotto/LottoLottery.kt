package org.bmsk.domain.model.lotto

data class LottoLottery(
    val numbers: List<Int>,
    val price: Int = DEFAULT_PRICE,
) {
    init {
        require(numbers.size == LOTTO_NUMBER_SIZE)
    }

    fun sorted(): LottoLottery = copy(numbers = numbers.sorted())
    fun contains(number: Int): Boolean = numbers.contains(number)

    companion object {
        private const val DEFAULT_PRICE = 1000
        const val LOTTO_NUMBER_SIZE = 6
    }
}
