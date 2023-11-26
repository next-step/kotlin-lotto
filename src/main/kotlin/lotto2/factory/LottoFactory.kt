package lotto2.factory

import lotto2.domain.LottoTicket

interface LottoFactory {
    fun generate(): List<LottoTicket>
}
