package lotto.domain

object LottoShop {
    fun sellByMoney(money: Money): Lottos {
        return Lottos(
            List(money.value / Lotto.PRICE) {
                Lotto()
            },
        )
    }
}
