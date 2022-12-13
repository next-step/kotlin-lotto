package com.nextstep.lotto.domain

import com.nextstep.lotto.domain.LottoTicket.Companion.LOTTO_PRICE

object LottoSeller {
    fun sellLotto(money: Long): LottoTickets {
        require(money > 0) { "돈은 음수가 될 수 없습니다." }
        val count = money / LOTTO_PRICE
        return LottoMachine.issue(count)
    }
}
