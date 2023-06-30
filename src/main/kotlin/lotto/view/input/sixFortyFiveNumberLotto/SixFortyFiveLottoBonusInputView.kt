package lotto.view.input.sixFortyFiveNumberLotto

import lotto.sixFortyFiveNumberLotto.SixFortyFiveNumber
import lotto.view.input.InputView

class SixFortyFiveLottoBonusInputView : InputView<Int, SixFortyFiveNumber>() {
    override val message: String = "보너스 볼을 입력해 주세요."
    override val value: SixFortyFiveNumber

    init {
        renderMessage()
        value = SixFortyFiveNumber(readValue())
    }

    override fun readValue(): Int {
        return readln().toInt()
    }
}
