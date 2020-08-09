package lotto.model

import kotlin.math.floor

object Store {

    fun drawLottoNumber(buyerLotto: List<Lotto>, winningLotto: Lotto, bonusBall: LottoNumber): List<Prize> =
        buyerLotto.map { it.convertPrize(winningLotto, bonusBall) }

    fun getRateOfReturn(price: Int, prizes: List<Prize>): Double {
        val totalPrize = prizes
            .map { it.price }
            .reduce { acc, money -> acc + money }
            .toDouble()

        return floor(totalPrize / price * 100.0) / 100.0
    }
}
