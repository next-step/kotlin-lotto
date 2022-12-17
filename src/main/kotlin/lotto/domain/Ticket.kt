package lotto.domain

import lotto.common.Money
import lotto.domain.policy.PricePolicy
import lotto.domain.policy.TargetNumbersGenerateStrategy
import lotto.domain.vo.TargetNumbers

class Ticket(
    pricePolicy: PricePolicy,
    targetNumbersGenerateStrategy: TargetNumbersGenerateStrategy
) {
    fun issue() {
        this.status = TicketStatus.ISSUE
    }

    val price: Money = pricePolicy.apply()
    var status: TicketStatus = TicketStatus.INIT
    val targetNumbers: TargetNumbers = targetNumbersGenerateStrategy.generate()
}