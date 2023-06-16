package lotto.view

import lotto.InputParser

object InputView {

    fun getBuyAmount(): Int {
        println("구입금액을 입력해 주세요.")
        val inputData = readlnOrNull() ?: throw IllegalArgumentException("입력값이 없습니다")
        return InputParser.getBuyAmount(inputData)
    }

    fun getWinNumbers(): List<Int> {
        println("지난 주 당첨 번호를 입력해 주세요.")
        val inputData = readlnOrNull() ?: throw IllegalArgumentException("입력값이 없습니다")
        return InputParser.parseWinNumbers(inputData)
    }
}
