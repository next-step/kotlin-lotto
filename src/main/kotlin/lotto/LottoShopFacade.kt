package lotto

import lotto.vo.Money

class LottoShopFacade(
    private val shops: List<LottoShop>,
) : LottoShop {
    override fun sell(cash: Money, purchaseCommand: PurchaseCommand): Pair<Lottos, Money> {
        var currentCash = cash
        var soldLottos = Lottos(listOf(), listOf())

        for (shop in shops) {
            if (currentCash < Lotto.PRICE) break

            val (lottos, remainingCash) = shop.sell(currentCash, purchaseCommand)
            soldLottos += lottos
            currentCash = remainingCash
        }

        return soldLottos to currentCash
    }
}
