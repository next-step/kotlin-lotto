package lotto.domain

import lotto.domain.strategy.LottoGenerateStrategy
import lotto.domain.strategy.TicketGenerateType

class LottoTicketBundle(
    lottoTicketCount: LottoTicketCount,
    lottoGenerateStrategies: List<LottoGenerateStrategy>,
) {
    private val lottoGenerateStrategyMap = lottoGenerateStrategies.associateBy { it.ticketGenerateType }

    val lottoTickets: List<LottoTicket> = List(lottoTicketCount.autoTicketCount) {
        val autoGenerateStrategy = lottoGenerateStrategyMap.getValue(TicketGenerateType.AUTO)
        autoGenerateStrategy.generate()
    } + List(lottoTicketCount.manualTicketCount) {
        val manualGenerateStrategy = lottoGenerateStrategyMap.getValue(TicketGenerateType.MANUAL)
        manualGenerateStrategy.generate()
    }
}
