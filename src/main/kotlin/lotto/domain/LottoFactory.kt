package lotto.domain

import Lottos

object LottoFactory {
    fun create(price: LottoPrice): Lottos {
        val purchaseCount = price.calculatePurchaseCount()
        val tickets = (1..purchaseCount).map { LottoRandomGenerator.randomGenerate() }
        return Lottos(tickets)
    }
}
