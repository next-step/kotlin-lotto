package lotto.view.input

import lotto.ErrorCode
import lotto.sixFortyFiveNumberLotto.SixFortyFiveLotto
import lotto.sixFortyFiveNumberLotto.SixFortyFiveNumber
import lotto.view.output.NewLineOutputView

class SixFortyFiveLottoLastWinNumInputView : InputView<List<SixFortyFiveNumber>, SixFortyFiveLotto>() {
    override val message: String = "지난 주 당첨 번호를 입력해 주세요."
    override val value: SixFortyFiveLotto

    init {
        renderMessage()
        value = SixFortyFiveLotto(readValue())
        NewLineOutputView()
    }

    override fun readValue(): List<SixFortyFiveNumber> {
        val numberList = runCatching {
            readln().split(DELIMITER).map { it.toInt() }
        }.onFailure {
            throw IllegalArgumentException(ErrorCode.INVALID_SIX_FORTY_FIVE_LOTTO_NUMBER_INPUT_FORMAT.msg)
        }.getOrThrow()
        return numberList.map { SixFortyFiveNumber(it) }
    }

    companion object {
        const val DELIMITER = ","
    }
}
