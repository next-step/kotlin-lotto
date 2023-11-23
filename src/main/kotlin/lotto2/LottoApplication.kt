package lotto2

import lotto2.application.LottoShop
import lotto2.domain.LottoNumber
import lotto2.domain.LottoNumbers
import lotto2.domain.WinningLotto
import lotto2.ui.ConsoleView

fun main() {
    ConsoleView.Input.printPurchaseAmountPrompt()
    val purchaseAmount = ConsoleView.Input.getPurchaseAmount()

    val lottoTickets = LottoShop.buyLottoTickets(purchaseAmount)
    ConsoleView.Output.printLottoGameResults(lottoTickets)

    ConsoleView.Input.printWinningNumbersPrompt()
    val lastLottoWinningNumbers = LottoNumbers(ConsoleView.Input.getLottoWinningNumbers())

    ConsoleView.Input.printBonusNumbersPrompt()
    val lastLottoBonusNumber = LottoNumber(ConsoleView.Input.getLottoBonusNumber())

    val winningLotto = WinningLotto(lastLottoWinningNumbers, lastLottoBonusNumber)
    val rankings = winningLotto.getRankings(lottoTickets)

    ConsoleView.Output.printWinningStatistics(
        rankings.getWinningStatistics()
    )

    ConsoleView.Output.printProfitRate(
        rankings.getProfitRate(lottoTickets.size * LottoShop.LOTTO_PRICE)
    )
}
