package lotto.dto

class LottoResult {

    private val result = LottoPrice.values().associateWith { 0 }.toMutableMap()

    fun updateExact(exact: LottoPrice) {
        result.computeIfPresent(exact) { _, v -> v + 1 }
    }

    fun getExact(exact: LottoPrice) = result[exact]

    fun getRatio(money: Int): Double {
        val sum = result.map { it.key.price * it.value }.sum()
        return sum.toDouble() / money
    }
}
