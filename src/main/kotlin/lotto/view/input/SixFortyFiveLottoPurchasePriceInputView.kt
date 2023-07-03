package lotto.view.input

import lotto.ErrorCode
import lotto.sixFortyFiveNumberLotto.SixFortyFiveLottoPurchasePrice
import lotto.view.output.NewLineOutputView

class SixFortyFiveLottoPurchasePriceInputView : InputView<Int, SixFortyFiveLottoPurchasePrice>() {
    override val message: String = "구입금액을 입력해 주세요."
    override val value: SixFortyFiveLottoPurchasePrice

    init {
        renderMessage()
        value = SixFortyFiveLottoPurchasePrice(readValue())
        NewLineOutputView()
    }

    override fun readValue(): Int {
        return runCatching {
            readln().toInt()
        }.onFailure {
            throw IllegalArgumentException(ErrorCode.INVALID_INPUT_INT_VALUE.msg)
        }.getOrThrow()
    }
}
