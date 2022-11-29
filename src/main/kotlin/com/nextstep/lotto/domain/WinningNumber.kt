package com.nextstep.lotto.domain

import com.nextstep.lotto.domain.LottoTicket.Companion.LOTTO_TICKET_COUNT

class WinningNumber(val winningNumbers: List<LottoNumber>) {
    init {
        require(winningNumbers.distinct().size == LOTTO_TICKET_COUNT) { "당첨 번호는 $LOTTO_TICKET_COUNT 개의 로또번호가 필요합니다." }
    }
}
