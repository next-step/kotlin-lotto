package com.nextstep.lotto.domain

object LottoMachine {
    fun issue(count: Long): LottoTickets {
        val list = mutableListOf<LottoTicket>()
        for (i in 1..count) {
            val numbers = LottoNumber.getAvailableNumbers().shuffled().take(6)
            val lottoTicket = LottoTicket(numbers)
            list.add(lottoTicket)
        }

        return LottoTickets(list)
    }
}
