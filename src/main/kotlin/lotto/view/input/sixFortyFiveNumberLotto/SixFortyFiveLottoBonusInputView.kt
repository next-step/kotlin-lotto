package lotto.view.input.sixFortyFiveNumberLotto

import lotto.ErrorCode
import lotto.sixFortyFiveNumberLotto.SixFortyFiveLottoNumber
import lotto.view.input.InputView

class SixFortyFiveLottoBonusInputView : InputView<Int>() {
    override val message: String = "보너스 볼을 입력해 주세요."
    override val value: Int

    init {
        renderMessage()
        value = readValue()
        if (!SixFortyFiveLottoNumber.validSingleNumber(value)) throw RuntimeException(ErrorCode.INVALID_SIX_FORTY_FIVE_LOTTO_NUMBER.msg)
    }

    override fun readValue(): Int {
        return readln().toInt()
    }
}
