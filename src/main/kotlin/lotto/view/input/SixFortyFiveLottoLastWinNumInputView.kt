package lotto.view.input

import lotto.SixFortyFiveLottoNumber

class SixFortyFiveLottoLastWinNumInputView : InputView<SixFortyFiveLottoNumber>() {
    override val message: String = "지난 주 당첨 번호를 입력해 주세요."
    override val value: SixFortyFiveLottoNumber

    override fun readValue(): SixFortyFiveLottoNumber {
        val numbers = readln().split(DELIMITER).map { it.toInt() }
        return SixFortyFiveLottoNumber(numbers)
    }

    init {
        renderMessage()
        value = readValue()
    }

    companion object {
        const val DELIMITER = ","
    }
}
