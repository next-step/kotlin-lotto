package lotto.dto

import lotto.utils.LOTTO_NUMBER_COUNT

class LottoResult {

    private val result = MutableList(LOTTO_NUMBER_COUNT + 1) { 0 }
    private val PRICE = listOf(0, 0, 0, 5_000, 50_000, 1_500_000, 2_000_000_000)

    fun updateExact(exact: Int) {
        result[exact]++
    }

    fun getExact(exact: Int) = result[exact]

    fun getRatio(money: Int): Double {
        val sum = result.mapIndexed { index, i -> i * PRICE[index] }.sum()
        return sum.toDouble() / money
    }

    fun getPrice(exact: Int) = PRICE[exact]
}
