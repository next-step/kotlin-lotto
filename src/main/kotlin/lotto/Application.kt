package lotto.view

import lotto.domain.LottoMachine
import lotto.domain.LottoNumberTokenizer
import lotto.domain.WinningLottoNumbers
import lotto.domain.WinningLottoStatistics

fun main() {
    val buyingPrice = InputView.enterLottoBuyingPrice()
    val lottoTickets = LottoMachine.buy(buyingPrice)
    ResultView.printLottoTickets(lottoTickets)
    val stringLottoNumbers = InputView.enterLastWeekWinningLottoNumbers()
    val winningLottoNumberTokens = LottoNumberTokenizer.tokenize(stringLottoNumbers)
    val bonusNumber = InputView.enterBonusNumber()

    val winningLottoNumbers = WinningLottoNumbers.of(winningLottoNumberTokens, bonusNumber)
    val winningLottoStatistics = WinningLottoStatistics(lottoTickets, winningLottoNumbers)
    val lottoProfitRate = winningLottoStatistics.calculateProfitRate(buyingPrice)
    ResultView.printWinningLottoStatistics(winningLottoStatistics)
    ResultView.printLottoProfitRate(lottoProfitRate)
}
