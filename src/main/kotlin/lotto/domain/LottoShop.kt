package lotto.domain

object LottoShop {
    fun sellByMoney(money: Int): Lottos {
        validateMoneyIsPositiveZero(money)

        return Lottos(List(money / Lotto.PRICE) { Lotto() })
    }

    private fun validateMoneyIsPositiveZero(money: Int) {
        require(money >= 0) { "로또 구입 금액은 0보다 커야 합니다." }
    }
}
