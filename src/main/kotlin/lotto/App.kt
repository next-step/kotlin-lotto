package lotto

import lotto.domain.Extractor
import lotto.domain.LottoMachine
import lotto.domain.LottoWinning
import lotto.view.InputView
import lotto.view.ResultView

private const val INVALID_MANUAL_TICKET_COUNT = "지급한 금액보다 수동 로또 티켓이 클수는 없습니다."

fun main() {
    val money = InputView.getMoney()

    val manualTicketCount = InputView.getManualTicketCount()

    require(money.lottoCount >= manualTicketCount) {
        INVALID_MANUAL_TICKET_COUNT
    }

    val manualNumbers = InputView.getManualNumbers(manualTicketCount)

    val lottoMachine = LottoMachine()

    val purchase = lottoMachine.purchase(money, manualNumbers, Extractor.randomNumberFunc)

    ResultView.printTickets(purchase)

    val lottoWinning = LottoWinning(
        numbers = InputView.getWinningNumbers(),
        bonusNumber = InputView.getBonusNumber()
    )

    val lottoPrizes = lottoWinning.getPrizes(purchase.totalTickets)

    ResultView.printResult(lottoPrizes.prizeCountInfo, lottoPrizes.earnings(money))
}
