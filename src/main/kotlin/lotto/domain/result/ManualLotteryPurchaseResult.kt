package lotto.domain.result

import lotto.domain.Money
import lotto.domain.lottery.LotteryTicket

class ManualLotteryPurchaseResult(
    override val lotteryTicket: LotteryTicket,
    override val change: Money,
) : LotteryPurchaseResult {
    override val type: PurchaseType = PurchaseType.MANUAL
}
