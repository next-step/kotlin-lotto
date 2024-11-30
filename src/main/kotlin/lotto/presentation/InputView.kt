package lotto.presentation

import lotto.core.LottoNumber

object InputView {
    fun inputPurchaseAmount(): String {
        println(GUIDE_INPUT_PURCHASE_AMOUNT)

        return readlnOrNull() ?: throw RuntimeException(ERROR_INVALID_INPUT)
    }

    fun inputWinningNumbers(): List<LottoNumber> {
        println(GUIDE_INPUT_LAST_WINNING_NUMBER)

        return splitNumbers(readlnOrNull() ?: throw RuntimeException(ERROR_INVALID_INPUT))
    }

    fun inputBonusNumber(): LottoNumber {
        println(GUIDE_INPUT_BONUS_NUMBER)
        val number = readlnOrNull() ?: throw RuntimeException(ERROR_INVALID_INPUT)
        return LottoNumber(number.toIntOrNull() ?: throw RuntimeException(ERROR_INVALID_INPUT))
    }

    private fun splitNumbers(winningNumbers: String): List<LottoNumber> {
        val numberList = winningNumbers.split(DELIMITER)
        val numbers = transformNumbers(numberList)
        checkDuplicates(numbers)
        return numbers
    }

    private fun transformNumbers(numberList: List<String>): List<LottoNumber> {
        return numberList.map {
            LottoNumber(it.trim().toIntOrNull() ?: throw NumberFormatException("숫자가 아닙니다."))
        }
    }

    private fun checkDuplicates(list: List<LottoNumber>) {
        if (list.size != list.toSet().size) {
            throw IllegalArgumentException("중복된 숫자가 있습니다.")
        }
    }

    private const val GUIDE_INPUT_PURCHASE_AMOUNT = "구입금액을 입력해 주세요."
    private const val GUIDE_INPUT_LAST_WINNING_NUMBER = "지난 주 당첨 번호를 입력해 주세요."
    private const val GUIDE_INPUT_BONUS_NUMBER = "보너스 볼을 입력해 주세요."
    private const val DELIMITER = ","
    private const val ERROR_INVALID_INPUT = "잘못된 값이 입력되었습니다."
}
