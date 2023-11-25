package lotto.domain

import lotto.error.InvalidLottoCountException

class LottoShop(
    private val price: Amount = Amount(1000)
) {

    fun toLottoPurchaseAmount(amount: Amount): LottoPurchaseAmount = LottoPurchaseAmount(amount, price)

    fun purchase(amount: Amount, manualLottoNumbers: List<LottoNumber>): LottoTicket {
        val autoLottoNumbers =
            List(calculateAutoLottoCount(LottoPurchaseAmount(amount, price), manualLottoNumbers.size)) {
                LottoNumberGenerator.createFrom()
            }
        return LottoTicket(manualLottoNumbers + autoLottoNumbers)
    }

    fun purchase(purchaseAmount: LottoPurchaseAmount, manualLottoNumbers: List<LottoNumber>): LottoTicket {
        val autoLottoNumbers = List(calculateAutoLottoCount(purchaseAmount, manualLottoNumbers.size)) {
            LottoNumberGenerator.createFrom()
        }
        return LottoTicket(manualLottoNumbers + autoLottoNumbers)
    }

    fun receivePrize(ticket: LottoTicket, winningLotto: WinningLotto): LottoResult =
        LottoResult.of(winningLotto, ticket, price)

    private fun calculateAutoLottoCount(amount: LottoPurchaseAmount, manualLottoNumberCount: Int): Int {
        val totalCount = amount.purchasedCount
        require(totalCount >= manualLottoNumberCount) { throw InvalidLottoCountException("수동 구입 로또 수가 구매 금액으로 구입할 수 있는 로또 수보다 큽니다") }
        return totalCount - manualLottoNumberCount
    }
}
