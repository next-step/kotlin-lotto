package com.nextstep.lotto.domain

class LottoTickets(val lottoTickets: List<LottoTicket>) {

    fun getCount(): Int = lottoTickets.size
}
