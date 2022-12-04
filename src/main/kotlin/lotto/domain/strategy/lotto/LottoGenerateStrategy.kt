package lotto.domain.strategy.lotto

import lotto.domain.LottoTicket

interface LottoGenerateStrategy {
    val generateType: GenerateType
    fun generate(): LottoTicket
}
