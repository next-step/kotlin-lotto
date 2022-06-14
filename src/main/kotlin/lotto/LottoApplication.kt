package lotto

import lotto.domain.LottoBuyer
import lotto.domain.LottoMoney
import lotto.domain.LottoNumbers
import lotto.domain.LottoStatistics
import lotto.view.InputView
import lotto.view.ResultView

fun main() {
    // 구매관련
    val money = InputView.askLottoMoney()
    val manualLottoCount = InputView.askManualLottoCount()
    val manualLottoNumbers = InputView.askManualLottoNumbers(manualLottoCount)

    ResultView.printBuyLottoCount(LottoMoney().getLottoCount(money))
    val lottoBuyer = LottoBuyer.buyer(money)
    ResultView.printBuyLottoNumber(lottoBuyer.lottoBuyList)

    // 당첨번호(보너스 번호 포함) 관련
    val winningLottoNumber = LottoNumbers(InputView.askWinningLottoNumbers())
    val winningLottoBonusNumber = InputView.askWinningLottoBonusNumber()

    // 통계관련
    val lottoStatistics = LottoStatistics(money, lottoBuyer.lottoBuyList, winningLottoNumber, winningLottoBonusNumber)
    ResultView.printWinningStatistics(lottoStatistics.resultMap, lottoStatistics.earningRate)
}
