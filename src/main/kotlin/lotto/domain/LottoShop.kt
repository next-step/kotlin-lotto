package lotto.domain

class LottoShop {
    fun buyLotto(money: PaidMoney): LottoTickets =
        LottoVendor.generate(
            numOfPurchases(money)
        )

    private fun numOfPurchases(paidMoney: PaidMoney) = (paidMoney.money / LOTTO_PRICE).toInt()
}
