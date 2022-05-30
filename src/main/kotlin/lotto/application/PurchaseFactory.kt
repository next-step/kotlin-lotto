package lotto.application

import lotto.application.vo.Amount
import lotto.application.vo.Purchase
import lotto.application.vo.PurchaseCount
import lotto.application.vo.PurchaseCounts

private const val LOTTO_PRICE = 1000

object PurchaseFactory {
    fun create(
        amount: Long,
        manualLottoCount: Int
    ): Purchase {
        require(manualLottoCount * LOTTO_PRICE <= amount) { "수동 로또 갯수가 구입 금액보다 클수 없습니다." }

        val autoLottoCount: Int = ((amount - manualLottoCount * LOTTO_PRICE) / LOTTO_PRICE).toInt()
        val purchaseCounts = PurchaseCounts(PurchaseCount(autoLottoCount), PurchaseCount(manualLottoCount))
        val amount = Amount(amount)

        return Purchase(amount, purchaseCounts)
    }
}
