package lotto.view

import lotto.domain.LottoMachine
import lotto.domain.LottoProfitRate
import lotto.domain.WinningLottoNumbers
import lotto.domain.WinningLottoStatistics

fun main() {
    val buyingPrice = InputView.enterLottoBuyingPrice()
    val lottoTickets = LottoMachine.buy(buyingPrice)
    ResultView.printLottoTickets(lottoTickets)

    val winningLottoNumbers = WinningLottoNumbers.from(InputView.enterLastWeekWinningLottoNumbers())
    val winningLottoStatistics = WinningLottoStatistics(lottoTickets, winningLottoNumbers)
    val lottoProfitRate = LottoProfitRate.calculateProfitRate(buyingPrice, winningLottoStatistics)
    ResultView.printWinningLottoStatistics(winningLottoStatistics)
    ResultView.printLottoProfitRate(lottoProfitRate)
}
