package lotto.domain

object LottoShop {
    fun sellByMoneyWithManualLottos(
        money: Money,
        manualLottos: Lottos = Lottos.random(getCountOfLottos(money)),
    ): Lottos {
        validateMoneyIsEnough(money, manualLottos)

        return manualLottos + getAutoLottos(money - manualLottos.cost)
    }

    private fun getAutoLottos(money: Money) = Lottos.random(getCountOfLottos(money))

    private fun getCountOfLottos(money: Money): Int {
        return money.value / Lotto.PRICE
    }

    private fun validateMoneyIsEnough(money: Money, lottos: Lottos) {
        require(money >= lottos.cost) { "금액이 부족합니다." }
    }
}
