package lotto.domain

object LottoShop {
    fun sellByMoney(money: Int): Lottos {
        return Lottos(List(money / Lotto.PRICE) { Lotto() })
    }
}
