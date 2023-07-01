package lotto.view.input

import lotto.sixFortyFiveNumberLotto.SixFortyFiveLottoCount
import lotto.view.output.NewLineOutputView

class SixFortyFiveManualLottoCountInputView : InputView<Int, SixFortyFiveLottoCount>() {
    override val message: String = "수동으로 구매할 로또 수를 입력해주세요."
    override val value: SixFortyFiveLottoCount

    init {
        renderMessage()
        value = SixFortyFiveLottoCount(readValue())
        NewLineOutputView()
    }

    override fun readValue(): Int {
        return readln().toInt()
    }
}
