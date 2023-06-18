package lotto.view.input.sixFortyFiveNumberLotto

import lotto.sixFortyFiveNumberLotto.SixFortyFiveLottoWinningNumber
import lotto.sixFortyFiveNumberLotto.SixFortyFiveNumber
import lotto.view.input.InputView

class SixFortyFiveLottoLastWinNumInputView : InputView<SixFortyFiveLottoWinningNumber>() {
    override val message: String = "지난 주 당첨 번호를 입력해 주세요."
    override val value: SixFortyFiveLottoWinningNumber

    override fun readValue(): SixFortyFiveLottoWinningNumber {
        val numbers = readln().split(DELIMITER).map { SixFortyFiveNumber(it.toInt()) }
        return SixFortyFiveLottoWinningNumber(numbers)
    }

    init {
        renderMessage()
        value = readValue()
    }

    companion object {
        const val DELIMITER = ","
    }
}
