package lotto.domain.result

import lotto.domain.Money
import lotto.domain.lottery.LotteryTicket

interface LotteryPurchaseResult {
    val lotteryTicket: LotteryTicket
    val change: Money
    val type: PurchaseType
}
