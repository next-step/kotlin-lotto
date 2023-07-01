package lotto.view.input

import lotto.sixFortyFiveNumberLotto.SixFortyFiveLotto
import lotto.sixFortyFiveNumberLotto.SixFortyFiveNumber
import lotto.view.output.NewLineOutputView

class SixFortyFiveLottoLastWinNumInputView : InputView<List<SixFortyFiveNumber>, SixFortyFiveLotto>() {
    override val message: String = "지난 주 당첨 번호를 입력해 주세요."
    override val value: SixFortyFiveLotto

    override fun readValue(): List<SixFortyFiveNumber> {
        return readln().split(DELIMITER).map { SixFortyFiveNumber(it.toInt()) }
    }

    init {
        renderMessage()
        value = SixFortyFiveLotto(readValue())
        NewLineOutputView()
    }

    companion object {
        const val DELIMITER = ","
    }
}
