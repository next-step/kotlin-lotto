package lotto.view.input.sixFortyFiveNumberLotto

import lotto.ErrorCode
import lotto.view.input.InputView
import java.lang.RuntimeException

class SixFortyFiveLottoChoiceInputView : InputView<Int, Int>() {
    override val message: String = "실행할 6/45 로또 버전을 선택하세요 (1.기본 로또 / 2.보너스 로또)"
    override val value: Int

    init {
        renderMessage()
        value = readValue()
    }

    override fun readValue(): Int {
        val value = readln().toInt()
        if (value != 1 && value != 2) throw RuntimeException(ErrorCode.INVALIE_SIX_FORTY_FIVE_LOTTO_VERSION.msg)
        return value
    }
}
