package lotto.presentation

import lotto.core.LottoNumber
import lotto.core.constant.LottoConstants

object InputView {
    fun inputPurchaseAmount(): String {
        println(GUIDE_INPUT_PURCHASE_AMOUNT)

        return readlnOrNull() ?: throw RuntimeException(LottoConstants.ERROR_INVALID_INPUT)
    }

    fun inputWinningNumbers(): List<LottoNumber> {
        println(GUIDE_INPUT_LAST_WINNING_NUMBER)

        return inputLottoNumbers()
    }

    fun inputBonusNumber(): LottoNumber {
        println(GUIDE_INPUT_BONUS_NUMBER)
        val number = readlnOrNull() ?: throw RuntimeException(LottoConstants.ERROR_INVALID_INPUT)
        return LottoNumber(number.trim().toIntOrNull() ?: throw RuntimeException(LottoConstants.ERROR_INVALID_INPUT))
    }

    fun inputManualLottoCount(): Int {
        println("수동으로 구매할 로또 수를 입력해주세요.")
        val number = readlnOrNull() ?: throw RuntimeException(LottoConstants.ERROR_INVALID_INPUT)

        val manualLottoCount = number.replace(" ", "").toIntOrNull() ?: throw RuntimeException(LottoConstants.ERROR_INVALID_INPUT)

        return manualLottoCount
    }

    fun inputManualLottoNumbers(manualLottoCount: Int): List<List<LottoNumber>> {
        println("수동으로 구매할 번호를 입력해 주세요.")

        return (1..manualLottoCount).map { inputLottoNumbers() }
    }

    private fun inputLottoNumbers(): List<LottoNumber> {
        return splitNumbers(readlnOrNull() ?: throw RuntimeException(LottoConstants.ERROR_INVALID_INPUT))
    }

    private fun splitNumbers(winningNumbers: String): List<LottoNumber> {
        val numberList = winningNumbers.split(DELIMITER)
        val numbers = transformNumbers(numberList)
        checkDuplicates(numbers)
        return numbers
    }

    private fun transformNumbers(numberList: List<String>): List<LottoNumber> {
        return numberList.map {
            LottoNumber(it.trim().toIntOrNull() ?: throw NumberFormatException(LottoConstants.ERROR_NOT_NUMBER))
        }
    }

    private fun checkDuplicates(list: List<LottoNumber>) {
        if (list.size != list.toSet().size) {
            throw IllegalArgumentException(LottoConstants.ERROR_DUPLICATE_NUMBER)
        }
    }

    private const val GUIDE_INPUT_PURCHASE_AMOUNT = "구입금액을 입력해 주세요."
    private const val GUIDE_INPUT_LAST_WINNING_NUMBER = "지난 주 당첨 번호를 입력해 주세요."
    private const val GUIDE_INPUT_BONUS_NUMBER = "보너스 볼을 입력해 주세요."
    private const val DELIMITER = ","
}
