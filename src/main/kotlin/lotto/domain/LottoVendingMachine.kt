package lotto.domain

object LottoVendingMachine {
    fun buy(purchaseAmount: PurchaseAmount): List<LottoNumbers> {
        return List(purchaseAmount.getNumberOfLotto()) { LottoNumbers() }
    }
}
