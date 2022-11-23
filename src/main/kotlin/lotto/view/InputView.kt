package lotto.view

import lotto.util.Reader

object InputView {
    private const val INPUT_MESSAGE = "구입금액을 입력해 주세요."
    fun read(): Int {
        println(INPUT_MESSAGE)
        return Reader.read().toInt()
    }
}
