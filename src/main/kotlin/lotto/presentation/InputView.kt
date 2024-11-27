package lotto.presentation

import lotto.core.constant.LottoConstants

object InputView {
    fun inputPurchaseAmount(): String {
        println(GUIDE_INPUT_PURCHASE_AMOUNT)

        return readlnOrNull() ?: throw RuntimeException("잘못된 값이 입력되었습니다.")
    }

    fun inputWinningNumbers(): List<Int> {
        println(GUIDE_INPUT_LAST_WINNING_NUMBER)

        return splitNumbers(readlnOrNull() ?: throw RuntimeException("잘못된 값이 입력되었습니다."))
    }

    private fun splitNumbers(winningNumbers: String): List<Int> {
        val numberList = winningNumbers.split(DELIMITER)
        val numbers = transformNumbers(numberList)
        checkInsideLottoNumber(numbers)
        checkDuplicates(numbers)
        return numbers
    }

    private fun transformNumbers(numberList: List<String>): List<Int> {
        return numberList.map { number -> number.trim().toIntOrNull() ?: throw NumberFormatException("숫자가 아닙니다.") }
    }

    private fun checkDuplicates(list: List<Int>) {
        if (list.size != list.toSet().size) {
            throw IllegalArgumentException("중복된 숫자가 있습니다.")
        }
    }

    private fun checkInsideLottoNumber(numbers: List<Int>) {
        numbers.forEach {
            if (it < LottoConstants.LOTTO_NUMBER_MIN || LottoConstants.LOTTO_NUMBER_MAX < it) {
                throw IllegalArgumentException("로또 숫자의 범위를 넘어섰습니다.")
            }
        }
    }

    private const val GUIDE_INPUT_PURCHASE_AMOUNT = "구입금액을 입력해 주세요."
    private const val GUIDE_INPUT_LAST_WINNING_NUMBER = "지난 주 당첨 번호를 입력해 주세요."
    private const val DELIMITER = ","
}
