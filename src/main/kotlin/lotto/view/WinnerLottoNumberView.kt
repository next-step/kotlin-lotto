package lotto.view

import lotto.domain.LottoNumber
import lotto.domain.LottoNumbers
import lotto.view.util.splitInputNumbersCommand

object WinnerLottoNumberView {
    fun inputWinningLottoNumbers(): LottoNumbers {
        println("\n지난 주 당첨 번호를 입력해 주세요.")
        val inputWinnerNumbersCommand: String? = readlnOrNull()
        requireNotNull(inputWinnerNumbersCommand) { INVALID_NULL_OR_BLANK_WINNER_NUMBERS_MESSAGE }

        return splitInputNumbersCommand(inputWinnerNumbersCommand)
    }

    fun inputBonusNumber(): LottoNumber {
        println("보너스 볼을 입력해 주세요.")
        val inputBonusNumberCommand: String? = readlnOrNull()
        requireNotNull(inputBonusNumberCommand) { INVALID_NULL_OR_BLANK_BONUS_NUMBERS_MESSAGE }
        val inputBonusNumber = inputBonusNumberCommand.toIntOrNull()
        requireNotNull(inputBonusNumber) { INVALID_BONUS_NUMBERS_MESSAGE }
        return LottoNumber.of(inputBonusNumber)
    }

    private const val INVALID_NULL_OR_BLANK_WINNER_NUMBERS_MESSAGE: String = "입력된 로또 당첨 번호가 없습니다"
    private const val INVALID_NULL_OR_BLANK_BONUS_NUMBERS_MESSAGE: String = "입력된 보너스 번호가 없습니다"
    private const val INVALID_BONUS_NUMBERS_MESSAGE: String = "입력된 보너스 번호가 올바르지 않습니다"
}
