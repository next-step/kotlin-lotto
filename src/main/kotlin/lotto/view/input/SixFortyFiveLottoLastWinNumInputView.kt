package lotto.view.input

class SixFortyFiveLottoLastWinNumInputView : InputView<List<Int>>() {
    override val message: String = "지난 주 당첨 번호를 입력해 주세요."
    override val value: List<Int>

    override fun readValue(): List<Int> {
        return readln().split(DELIMITER).map { it.toInt() }
    }

    init {
        renderMessage()
        value = readValue()
    }

    companion object {
        const val DELIMITER = ","
    }
}
