package lotto.view.input.sixFortyFiveNumberLotto

import lotto.view.input.InputView
import lotto.view.output.NewLineOutputView

class SixFortyFiveManualLottoCountInputView : InputView<Int, Int>() {
    override val message: String = "수동으로 구매할 로또 수를 입력해주세요."
    override val value: Int

    init {
        renderMessage()
        value = readValue()
        NewLineOutputView()
    }

    override fun readValue(): Int {
        return readln().toInt()
    }
}
