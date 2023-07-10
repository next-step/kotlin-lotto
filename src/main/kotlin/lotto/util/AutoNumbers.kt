package lotto.util

import lotto.domain.LottoTicket

interface AutoNumbers {
    fun generateNumbers(): LottoTicket
}
