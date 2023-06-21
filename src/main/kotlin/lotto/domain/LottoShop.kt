package lotto.domain

object LottoShop {
    fun sellByMoney(money: Money, lottos: Lottos = Lottos.random(getCountOfLottos(money))): Lottos {
        return lottos
    }

    private fun getCountOfLottos(money: Money): Int {
        return money.value / Lotto.PRICE
    }
}
