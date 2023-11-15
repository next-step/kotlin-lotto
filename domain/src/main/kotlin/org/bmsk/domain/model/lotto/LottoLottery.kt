package org.bmsk.domain.model.lotto

data class LottoLottery(
    val numbers: List<Int>,
    val price: Int = DEFAULT_PRICE,
) {
    fun sorted(): LottoLottery = copy(numbers = numbers.sorted())
    fun contains(number: Int): Boolean = numbers.contains(number)

    companion object {
        private const val DEFAULT_PRICE = 1000
    }
}
