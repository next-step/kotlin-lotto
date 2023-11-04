package lotto.dto

class LottoResult {

    private val result = LottoPrice.values().associateWith { 0 }.toMutableMap()

    fun updateExact(exact: Int) {
        result.computeIfPresent(LottoPrice.from(exact)) { _, v -> v + 1 }
    }

    fun getExact(exact: Int) = result[LottoPrice.from(exact)]

    fun getRatio(money: Int): Double {
        val sum = result.map { it.key.price * it.value }.sum()
        return sum.toDouble() / money
    }

    fun getPrice(exact: Int) = LottoPrice.getPrice(exact)
}
