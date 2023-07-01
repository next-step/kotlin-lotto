package lotto.view.input

import lotto.sixFortyFiveNumberLotto.SixFortyFiveNumber
import lotto.view.output.NewLineOutputView

class SixFortyFiveLottoBonusInputView : InputView<Int, SixFortyFiveNumber>() {
    override val message: String = "보너스 볼을 입력해 주세요."
    override val value: SixFortyFiveNumber

    init {
        renderMessage()
        value = SixFortyFiveNumber(readValue())
        NewLineOutputView()
    }

    override fun readValue(): Int {
        return readln().toInt()
    }
}
