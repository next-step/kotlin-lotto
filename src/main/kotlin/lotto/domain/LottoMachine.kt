package lotto.domain

import lotto.domain.strategy.bonus.BonusGenerateStrategy
import lotto.domain.strategy.lotto.GenerateType
import lotto.domain.strategy.lotto.LottoGenerateStrategy

class LottoMachine(
    money: Int,
    manualTicketCount: Int,
    lottoGenerateStrategies: List<LottoGenerateStrategy>,
    private val winnerLottoGenerateStrategy: LottoGenerateStrategy,
    private val bonusGenerateStrategy: BonusGenerateStrategy,
) {
    private val lottoGenerateStrategyMap = lottoGenerateStrategies.associateBy { it.generateType }
    val lottoTickets: LottoTickets = initializeLottoTickets(money, manualTicketCount)

    fun execute(): LottoResultSummary {
        val winnerLottoTicket = getWinnerTicket()
        val matchResults = lottoTickets.map { ticket ->
            val countMatchResult = winnerLottoTicket.countMatchNumber(ticket)
            MatchResult.of(countMatchResult.count, countMatchResult.isBonusNumberMatched)
        }
        return LottoResultSummary(matchResults)
    }

    private fun initializeLottoTickets(money: Int, manualTicketCount: Int): LottoTickets {
        val autoTicketCount = (money / TICKET_AMOUNT) - manualTicketCount
        val autoGenerateStrategy = lottoGenerateStrategyMap.getValue(GenerateType.AUTO)
        val manualGenerateStrategy = lottoGenerateStrategyMap.getValue(GenerateType.MANUAL)
        return LottoTickets(
            ticketCategoryCount = TicketCategoryCount(manualTicketCount, autoTicketCount),
            tickets = List(manualTicketCount) { manualGenerateStrategy.generate() } + List(autoTicketCount) { autoGenerateStrategy.generate() }
        )
    }

    private fun getWinnerTicket(): WinnerLottoTicket {
        val winnerLottoNumbers = winnerLottoGenerateStrategy.generate()
        val bonusNumber = bonusGenerateStrategy.generate()
        return WinnerLottoTicket(winnerLottoNumbers, bonusNumber)
    }

    companion object {
        private const val TICKET_AMOUNT = 1000
    }
}
