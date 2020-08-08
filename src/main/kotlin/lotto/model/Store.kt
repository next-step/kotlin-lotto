package lotto.model

import kotlin.math.floor

class Store(private val buyer: Buyer) {

    fun drawLottoNumber(winningLotto: Lotto, bonusBall: Int): List<Prize> =
        buyer.lotto.map { it.convertPrize(winningLotto, bonusBall) }

    fun getRateOfReturn(price: Int, prizes: List<Prize>): Double {
        val totalPrize = prizes
            .map { it.price }
            .reduce { acc, money -> acc + money }
            .toDouble()

        return floor(totalPrize / price * 100.0) / 100.0
    }
}
