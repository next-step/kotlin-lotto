package lotto.view

import java.lang.IllegalArgumentException

class LottoInputView {
    fun inputLottoBuy(): Int {
        println(LOTTO_BUY_COMMENT)
        return readLineOrThrows().toInt()
    }

    fun inputWinningLotto(): List<Int> {
        println(WINNING_LOTTO_COMMENT)
        return readLineOrThrows().replace(" ", "").split(",").map { it.toInt() }
    }

    private fun readLineOrThrows(): String = readLine() ?: throw IllegalArgumentException()

    companion object {
        private const val LOTTO_BUY_COMMENT = "구입금액을 입력해 주세요."
        private const val WINNING_LOTTO_COMMENT = "지난 주 당첨 번호를 입력해 주세요."
    }
}
