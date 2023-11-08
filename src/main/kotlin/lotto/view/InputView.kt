package lotto.view

import java.lang.IllegalArgumentException

object InputView {
    private const val PURCHASE_AMOUNT_QUESTION = "구입금액을 입력해 주세요."
    private const val WINNING_NUMBERS_QUESTION = "지난 주 당첨 번호를 입력해 주세요."

    fun getPurchaseInput(): String {
        println(PURCHASE_AMOUNT_QUESTION)
        return readlnOrNull() ?: throw IllegalArgumentException("입력 값이 없습니다.")
    }

    fun getWinningNumbersInput(): String {
        println(WINNING_NUMBERS_QUESTION)
        return readlnOrNull() ?: throw IllegalArgumentException("입력 값이 없습니다.")
    }
}
