package lotto.domain

import lotto.domain.lottoticket.LottoTickets
import lotto.view.InputView
import lotto.view.OutputView

class LottoGame(
    private val inputView: InputView = InputView(),
    private val outputView: OutputView = OutputView(),
) {
    fun play() {
        val lottoTicketMachine = LottoTicketMachine(Money(inputView.inputBigDecimal()))
        val manualLottoTickets = buyManualLottoTickets(lottoTicketMachine)
        // outputView.printLottos(lottoTickets.values)

        val inputWinningNumbers = inputView.inputWinningNumbers()
        val inputBonusNumber = inputView.inputBonusNumber()
        val winningTicket = WinningTicket.of(
            lottoNumbers = inputWinningNumbers, bonusNumber = inputBonusNumber
        )

        val matchResults = manualLottoTickets.totalMatchResults(winningTicket)
        outputView.printWinningResult(matchResults.amountWithWinnings)
        outputView.printYield(matchResults.calculateYield())
    }

    private fun buyManualLottoTickets(lottoTicketMachine: LottoTicketMachine): LottoTickets {
        val buyManualLottoTicketCount = inputView.inputManualLottoTicketCount()
        inputView.noticeInputManualLottoTicketNumbers()

        return LottoTickets(
            values = List(buyManualLottoTicketCount) {
                lottoTicketMachine.buyManualLottoTickets(inputView.inputManualLottoTicketNumbers())
            }
        )
    }
}
