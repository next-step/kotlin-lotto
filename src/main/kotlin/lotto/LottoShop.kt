package lotto

import java.lang.RuntimeException

class LottoShop {

    fun buyLotto(money: Int): List<LottoTicket> {
        moneyValidate(money)
        val numberOfBuy = money / LottoPolicy.LOTTO_PRICE

        return List(numberOfBuy) { LottoCreator.autoCreate() }
    }

    private fun moneyValidate(money: Int) {
        if (money < LottoPolicy.LOTTO_PRICE) {
            throw RuntimeException("로또 구매 비용이 부족합니다. - `$money` (최소`${LottoPolicy.LOTTO_PRICE}` 이상 필요)")
        }
    }
}
