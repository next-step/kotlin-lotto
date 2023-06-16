package lotto.view

import lotto.InputValidator

object InputView {

    fun getBuyAmount(): Int {
        println("구입금액을 입력해 주세요.")
        val inputData = readlnOrNull() ?: throw IllegalArgumentException("입력값이 없습니다")
        return InputValidator.getBuyAmount(inputData)
    }

    fun getWinNumbers(): List<Int> {
        println("구입금액을 입력해 주세요.")
        val inputData = readlnOrNull() ?: throw IllegalArgumentException("입력값이 없습니다")
        return InputValidator.parseWinNumbers(inputData)
    }
}
