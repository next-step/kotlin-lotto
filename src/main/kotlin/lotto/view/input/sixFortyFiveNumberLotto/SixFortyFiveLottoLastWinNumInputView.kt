package lotto.view.input.sixFortyFiveNumberLotto

import lotto.sixFortyFiveNumberLotto.SixFortyFiveLotto
import lotto.sixFortyFiveNumberLotto.SixFortyFiveNumber
import lotto.view.input.InputView

class SixFortyFiveLottoLastWinNumInputView : InputView<SixFortyFiveLotto>() {
    override val message: String = "지난 주 당첨 번호를 입력해 주세요."
    override val value: SixFortyFiveLotto

    override fun readValue(): SixFortyFiveLotto {
        val numbers = readln().split(DELIMITER).map { SixFortyFiveNumber(it.toInt()) }
        return SixFortyFiveLotto(numbers)
    }

    init {
        renderMessage()
        value = readValue()
    }

    companion object {
        const val DELIMITER = ","
    }
}
