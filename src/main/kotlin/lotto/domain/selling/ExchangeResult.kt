package lotto.domain.selling

data class ExchangeResult(val details: Map<Int, Int>) {
    val totalPrizeMoney = details.keys.sumBy { Prize.findMoney(it) }

    fun calculateRateOfReturn(): Double {
        val origin = details.entries.sumBy { it.value } * Seller.LOTTO_PRICE
        return totalPrizeMoney.toDouble() / origin
    }
}
