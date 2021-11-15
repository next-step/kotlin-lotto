package lotto.domain

import lotto.domain.LottoTicket.Companion.validateInTheThousands
import lotto.domain.LottoTicket.Companion.validateMoreThan1000

@JvmInline
value class Money private constructor(val value: Int) {
    fun convertToLottoTicketCount(): Int {
        return value / LottoTicket.getCostForOneTicket()
    }

    companion object {
        fun makeForBuyingLotto(value: Int): Money {
            validateMoreThan1000(value)
            validateInTheThousands(value)
            return Money(value)
        }
    }
}
