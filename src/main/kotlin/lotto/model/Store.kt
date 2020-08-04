package lotto.model

import kotlin.math.floor

class Store(private val buyer: Buyer) {

    fun drawLottoNumber(lastWeekLottoNumbers: List<Int>): List<Prize> =
        buyer.purchasedLottos.map { it.convertPrize(lastWeekLottoNumbers) }

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
