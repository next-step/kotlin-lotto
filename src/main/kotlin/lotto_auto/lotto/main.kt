package lotto_auto.lotto

import lotto_auto.ui.InputView
import lotto_auto.ui.OutputView

fun main() {
    val inputAmount = InputView.input()
    val count = InputView.lottoCount(inputAmount)

    val lottoList = (1..count).map { Lotto() }
    OutputView.print(lottoList)

    val bonusBallNumber = InputView.bonusBallInput()
    val lastWeekLottoNumber = InputView.lastWeekInput().toWinningLotto(bonusBallNumber)
    val matchedLottoCountWithBonusBall = LottoAuto.matchedLottoCountWithBonusBall(lottoList, lastWeekLottoNumber)

    val sumOfWonLotto = LottoAuto.sumOfWonLottoList(matchedLottoCountWithBonusBall)

    val resultRate: Float = LottoAuto.earningRate(sumOfWonLotto, inputAmount)

    val matchCountList =
        LottoAuto.matchCountList(matchedLottoCountWithBonusBall.map { LottoPrize.getLottoPrize(it.first.matchCount, it.second) })

    OutputView.showResult(matchCountList, resultRate)
}
