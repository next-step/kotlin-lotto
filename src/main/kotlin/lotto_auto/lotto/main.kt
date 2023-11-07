package lotto_auto.lotto

import lotto_auto.ui.InputView
import lotto_auto.ui.OutputView

fun main() {
    val inputAmount = InputView.input()
    val count = InputView.lottoCount(inputAmount)

    val lottoList = (1..count).map { Lotto() }
    OutputView.print(lottoList)

    val lastWeekLottoNumber = InputView.lastWeekInput().toLotto()
    val eachLottoMatchCount = lottoList.map { it.lottoMatchCount(lastWeekLottoNumber) }.filter { it > 2 }

    val bonusBallNumber = InputView.bonusBallInput()

    val sumOfWonLotto = LottoAuto.sumOfWonLottoList(eachLottoMatchCount)

    val resultRate: Float = LottoAuto.earningRate(sumOfWonLotto, inputAmount)

    val matchCountList = LottoAuto.matchCountList(eachLottoMatchCount.map { LottoPrize.getLottoPrize(it) })

    OutputView.showResult(matchCountList, resultRate)
}
