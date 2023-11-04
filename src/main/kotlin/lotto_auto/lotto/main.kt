package lotto_auto.lotto

import lotto_auto.ui.InputView
import lotto_auto.ui.OutputView

fun main() {
    val inputAmount = InputView.input()
    val count = InputView.lottoCount(inputAmount)

    val lottoList = LottoAuto.createLottoList(count)
    OutputView.print(lottoList)

    val lastWeekLottoNumber = InputView.lastWeekInput()

    val resultSum = LottoAuto.resultSum(lottoList, lastWeekLottoNumber)

    val resultRate: Float = LottoAuto.earningRate(resultSum, inputAmount)

    val matchCountList = LottoAuto.matchCountList(lottoList, lastWeekLottoNumber)

    OutputView.showResult(matchCountList, resultRate)
}
