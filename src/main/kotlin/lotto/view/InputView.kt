package lotto.view

import lotto.constants.Messages

/**
 * 입력을 받는 클래스, 기본적인 필터링만 한다.
 * Created by Jaesungchi on 2022.05.24..
 */
object InputView {
    fun getPrice(readStringValue: () -> String? = { readlnOrNull() }): Int {
        println(Messages.WRITE_YOUR_MONEY)
        return changeStringToInt(readStringValue())
    }

    fun getWinningNumber(readStringValue: () -> String? = { readlnOrNull() }): String {
        println(Messages.WRITE_WINNING_NUMBER)
        val input = readStringValue()
        require(!input.isNullOrBlank())
        return input
    }

    private fun changeStringToInt(input: String?): Int {
        require(!input.isNullOrBlank())
        return input.toIntOrNull() ?: throw IllegalArgumentException()
    }
}
