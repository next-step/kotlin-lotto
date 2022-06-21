package lotto.domain

import lotto.domain.Money.PaidMoney

class LottoShop {
    fun buyLotto(money: PaidMoney): LottoTickets =
        LottoVendor.generate(
            numOfPurchases(money)
        )
    private fun numOfPurchases(paidMoney: PaidMoney) = (paidMoney.money / LOTTO_PRICE).toInt()
}
