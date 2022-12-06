package com.nextstep.lotto.domain

import com.nextstep.lotto.domain.LottoTicket.Companion.LOTTO_TICKET_COUNT

object LottoMachine {
    fun issue(count: Long): LottoTickets {
        require(count > 0) { "양수로 발행 해야 합니다." }
        val lottoTickets = List(count.toInt()) {
            val numbers = LottoNumber.getAvailableNumbers().shuffled().take(LOTTO_TICKET_COUNT)
            LottoTicket(numbers.toSet())
        }

        return LottoTickets(lottoTickets)
    }
}
