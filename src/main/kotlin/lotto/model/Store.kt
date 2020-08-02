package lotto.model

import kotlin.math.floor

class Store(private val buyer: Buyer) {

    fun confirmLottoWining(lottoNumbers: List<Int>): List<Prize> {
        val results = mutableListOf<Prize>()
        for (lotto in buyer.purchasedLottos) {
            val matchCount = lotto.numbers.count { lottoNumbers.contains(it) }
            results.add(Prize.findByMatchCount(matchCount))
        }
        return results
    }

    fun getRateOfReturn(price: Int, prizes: List<Prize>): Double {
        val totalPrize = prizes
            .map { it.price }
            .reduce { acc, money ->
                acc + money
            }
            .toDouble()

        return floor(totalPrize / price * 100.0) / 100.0
    }
}
