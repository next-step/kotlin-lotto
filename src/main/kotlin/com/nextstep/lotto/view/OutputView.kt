package com.nextstep.lotto.view

import com.nextstep.lotto.domain.LottoTickets

class OutputView {

    fun printLottoTicketCount(count: Int, lottoTickets: LottoTickets) {
        println("${count}개를 구매했습니다.")
        lottoTickets.lottoTickets.forEach { println(it.getNumbers()) }
    }
}
