package lotto.view.input

import lotto.sixFortyFiveNumberLotto.SixFortyFiveLottoPurchasePrice
import lotto.view.output.NewLineOutputView

class SixFortyFiveLottoPurchasePriceInputView : InputView<Int, SixFortyFiveLottoPurchasePrice>() {
    override val message: String = "구입금액을 입력해 주세요."
    override val value: SixFortyFiveLottoPurchasePrice

    override fun readValue(): Int {
        return readln().toInt()
    }

    init {
        renderMessage()
        value = SixFortyFiveLottoPurchasePrice(readValue())
        NewLineOutputView()
    }
}
