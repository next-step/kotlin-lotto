package lotto_auto.lotto

import lotto_auto.ui.InputView
import lotto_auto.ui.OutputView

fun main() {
    val inputAmount = InputView.input()
    val count = InputView.lottoCount(inputAmount)

    val lottoList = (1..count).map { Lotto() }
    OutputView.print(lottoList)

    val lastWeekLottoNumber = InputView.lastWeekInput().toLotto()
    val lottoAuto = LottoAuto(lottoList, lastWeekLottoNumber)

    val sumOfWonLotto = lottoAuto.sumOfWonLottoList()

    val resultRate: Float = lottoAuto.earningRate(sumOfWonLotto, inputAmount)

    val matchCountList = lottoAuto.matchCountList()

    OutputView.showResult(matchCountList, resultRate)
}
