package lotto.domain

import lotto.common.value.Money
import lotto.domain.enums.TicketStatus
import lotto.domain.policy.LotteryNumbersGenerateStrategy
import lotto.domain.policy.PricePolicy
import lotto.domain.vo.LotteryNumbers

class Ticket(
    pricePolicy: PricePolicy,
    lotteryNumbersGenerateStrategy: LotteryNumbersGenerateStrategy
) {

    val price: Money = pricePolicy.apply()
    var status: TicketStatus = TicketStatus.INIT
    val lotteryNumbers: LotteryNumbers = lotteryNumbersGenerateStrategy.generate()

    fun issue() {
        check(this.status == TicketStatus.INIT) { "티켓이 발급될 상태가 아닙니다" }
        this.status = TicketStatus.ISSUE
    }
}
