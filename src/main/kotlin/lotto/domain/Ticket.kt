package lotto.domain

import lotto.common.Money
import lotto.domain.policy.PricePolicy
import lotto.domain.policy.LotteryNumbersGenerateStrategy
import lotto.domain.vo.LotteryNumbers

class Ticket(
    pricePolicy: PricePolicy,
    lotteryNumbersGenerateStrategy: LotteryNumbersGenerateStrategy
) {
    fun issue() {
        this.status = TicketStatus.ISSUE
    }

    val price: Money = pricePolicy.apply()
    var status: TicketStatus = TicketStatus.INIT
    val lotteryNumbers: LotteryNumbers = lotteryNumbersGenerateStrategy.generate()
}