package lotto_auto.lotto

import lotto_auto.ui.InputView
import lotto_auto.ui.OutputView

fun main() {
    val count = InputView.input()

    val lottoList = LottoAuto.createLottoList(count)
    OutputView.print(lottoList)
    InputView.lastWeekInput()
}
