package lotto

import lotto.domain.LottoBuyer
import lotto.domain.LottoMoney
import lotto.domain.LottoStatistics
import lotto.view.InputView
import lotto.view.ResultView

fun main() {
    // 구매관련
    val money = InputView.askLottoMoney()
    ResultView.printBuyLottoCount(LottoMoney().getLottoCount(money))
    val lottoBuyer = LottoBuyer.buyer(money)
    ResultView.printBuyLottoNumber(lottoBuyer.lottoNumbers)

    // 당첨번호 관련
    val printWinningLottoNumber = InputView.askWinningLottoNumbers()

    // 통계관련
    val lottoStatistics = LottoStatistics(money, lottoBuyer.lottoNumbers, printWinningLottoNumber)
    ResultView.printWinningStatistics(lottoStatistics.resultMap, lottoStatistics.earningRate)
}
