package lotto

import lotto.model.process.MachineProcess
import lotto.view.keyboard.Keyboard
import lotto.view.monitor.Monitor

class LottoMachine(
    private val process: MachineProcess,
    private val keyboard: Keyboard,
    private val monitor: Monitor,
) : Machine {
    override fun issuanceLottoNumber() {
        monitor.displayLottoPurchaseAmount()
        val totalPurchaseAmount = keyboard.inputLottoPrice()
        val lottoCount = process.calculateLottoCount(totalPurchaseAmount)
        monitor.displayLottoPurchasesCount(lottoCount)

        val lottoTickets = process.generateLottoTickets(lottoCount)
        monitor.displayIssuedLottoTickets(lottoTickets)

        monitor.displayInputLastWeekLottoWinningNumbers()
        val lastWeekNumbers = keyboard.inputLastWeekWinningNumbers()
        val lottoStatistics =
            process.calculateWinningStatistics(
                lottoTickets,
                lastWeekNumbers,
                totalPurchaseAmount,
            )
        monitor.displayLottoStatistics(lottoStatistics)
    }
}
