package lotto.domain

object LottoVendingMachine {
    private const val LOTTO_PRICE = 1_000.00

    fun buy(purchaseAmount: PurchaseAmount): List<LottoNumbers> {
        return List(getNumberOfLotto(purchaseAmount)) { LottoNumbers() }
    }

    private fun getNumberOfLotto(purchaseAmount: PurchaseAmount): Int {
        return (purchaseAmount.amount / LOTTO_PRICE).toInt()
    }
}
