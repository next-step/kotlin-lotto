package lotto.model

import kotlin.math.floor

class Store(private val buyer: Buyer) {

    fun drawLottoNumber(lastWeekLotto: Lotto, matchedBonusBall: Boolean = false): List<Prize> =
        buyer.purchasedLottos.map { it.convertPrize(lastWeekLotto, matchedBonusBall) }

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
