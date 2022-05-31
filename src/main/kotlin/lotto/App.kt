package lotto

import lotto.domain.Extractor
import lotto.domain.LottoMachine
import lotto.domain.LottoWinning
import lotto.view.InputView
import lotto.view.ResultView

fun main() {
    val money = InputView.getMoney()

    val manualTicketCount = InputView.getManualTicketCount()

    val lottoMachine = LottoMachine()

    val lottoTickets = lottoMachine.purchase(money, Extractor.randomNumberFunc)

    ResultView.printTickets(lottoTickets)

    val lottoWinning = LottoWinning(
        numbers = InputView.getWinningNumbers(),
        bonusNumber = InputView.getBonusNumber()
    )

    val lottoPrizes = lottoWinning.getPrizes(lottoTickets)

    ResultView.printResult(lottoPrizes.prizeResult, lottoPrizes.earnings(money))
}
