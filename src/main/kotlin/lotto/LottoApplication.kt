package lotto

import lotto.domain.LottoBuyer
import lotto.domain.LottoBuyerCount
import lotto.domain.LottoNumbers
import lotto.domain.LottoStatistics
import lotto.view.InputView
import lotto.view.ResultView

fun main() {
    // 구매관련
    val money = InputView.askLottoMoney()
    val lottoBuyerCount = LottoBuyerCount(money, InputView.askManualLottoCount())
    val manualLottoNumbers = InputView.askManualLottoNumbers(lottoBuyerCount.manualLottoCount)
    ResultView.printBuyLottoCount(lottoBuyerCount)

    val lottoBuyer = LottoBuyer.buyer(manualLottoNumbers, lottoBuyerCount.autoLottoCount)
    ResultView.printBuyLottoNumber(lottoBuyer.lottoBuyList)

    // 당첨번호(보너스 번호 포함) 관련
    val winningLottoNumber = LottoNumbers(InputView.askWinningLottoNumbers())
    val winningLottoBonusNumber = InputView.askWinningLottoBonusNumber()

    // 통계관련
    val lottoStatistics = LottoStatistics(money, lottoBuyer.lottoBuyList, winningLottoNumber, winningLottoBonusNumber)
    ResultView.printWinningStatistics(lottoStatistics.resultMap, lottoStatistics.earningRate)
}
