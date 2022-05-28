package lotto

import lotto.domain.LottoBuyer
import lotto.domain.LottoStatistics
import lotto.view.InputView
import lotto.view.ResultView

fun main() {
    // 구매관련
    val buyMoney = InputView.askLottoBuyMoney()
    ResultView.printBuyLottoCount(buyMoney / 1000)
    val lottoBuyer = LottoBuyer()
    lottoBuyer.buyLotto(buyMoney)
    ResultView.printBuyLottoNumber(lottoBuyer.lottoNumbers)

    // 당첨번호 관련
    val printWinningLottoNumber = InputView.askWinningLottoNumbers()

    // 통계관련
    val calculateWinningTotalMoney = LottoStatistics.calculateWinningTotalMoney(lottoBuyer.lottoNumbers, printWinningLottoNumber)
    val earningRate = LottoStatistics.calculateEarningRate(buyMoney, calculateWinningTotalMoney)
    ResultView.printWinningStatistics(lottoBuyer.lottoNumbers, printWinningLottoNumber, earningRate)
}
