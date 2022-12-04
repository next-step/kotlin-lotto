package lotto.domain.strategy.lotto

import lotto.domain.LottoTicket

interface LottoGenerateStrategy {
    fun generate(): LottoTicket
}
