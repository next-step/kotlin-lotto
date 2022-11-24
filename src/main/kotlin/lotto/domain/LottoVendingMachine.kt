package lotto.domain

class LottoVendingMachine {
    companion object {
        private const val LOTTO_PRICE = 1000.00

        fun buy(purchaseAmount: PurchaseAmount): List<LottoNumber> {
            return List(getNumberOfLotto(purchaseAmount)) { LottoNumber() }
        }

        private fun getNumberOfLotto(purchaseAmount: PurchaseAmount): Int {
            return (purchaseAmount.amount / LOTTO_PRICE).toInt()
        }
    }
}
