package com.nextstep.lotto.domain

import com.nextstep.lotto.domain.LottoTicket.Companion.LOTTO_TICKET_COUNT

object LottoMachine {
    fun issue(count: Long): LottoTickets {
        val lottoTickets = (1..count).map {
            val numbers = LottoNumber.getAvailableNumbers().shuffled().take(LOTTO_TICKET_COUNT)
            LottoTicket(numbers)
        }

        return LottoTickets(lottoTickets)
    }
}
