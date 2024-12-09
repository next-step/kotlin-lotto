package lotto.view

object WinnerLottoNumberView {
    fun inputWinningLottoNumbers(): Set<Int> {
        println("\n지난 주 당첨 번호를 입력해 주세요.")
        val inputWinnerNumbersCommand: String? = readlnOrNull()
        requireNotNull(inputWinnerNumbersCommand) { INVALID_NULL_OR_BLANK_WINNER_NUMBERS_MESSAGE }

        val splitInputWinnerNumbers = splitInputWinnerNumbersCommand(inputWinnerNumbersCommand)
        require(splitInputWinnerNumbers.size == 6) { INVALID_WINNER_NUMBERS_COUNT_MESSAGE }
        return splitInputWinnerNumbers
    }

    fun inputBonusNumber(): Int {
        println("보너스 볼을 입력해 주세요.")
        val inputBonusNumberCommand: String? = readlnOrNull()
        requireNotNull(inputBonusNumberCommand) { INVALID_NULL_OR_BLANK_BONUS_NUMBERS_MESSAGE }
        val inputBonusNumber = inputBonusNumberCommand.toIntOrNull()
        requireNotNull(inputBonusNumber) { INVALID_BONUS_NUMBERS_MESSAGE }
        return inputBonusNumber
    }

    private fun splitInputWinnerNumbersCommand(inputWinnerNumbersCommand: String): Set<Int> {
        require(inputWinnerNumbersCommand.isNotBlank()) { INVALID_BLANK_WINNER_NUMBERS_MESSAGE }
        require(inputWinnerNumbersCommand.contains(WINNER_NUMBERS_DELIMITER)) {
            INVALID_DELIMITER_WINNER_NUMBERS_MESSAGE
        }

        return inputWinnerNumbersCommand.split(WINNER_NUMBERS_DELIMITER)
            .map { inputWinnerNumber -> lottoNumberStringToInt(numberString = inputWinnerNumber.trim()) }
            .toSet()
    }

    private fun lottoNumberStringToInt(numberString: String): Int {
        val lottoNumberOrNull = numberString.toIntOrNull()

        requireNotNull(lottoNumberOrNull) { INVALID_WINNER_NUMBERS_TO_INT_MESSAGE }
        require((LOTTO_NUMBER_MIN_VALUE..LOTTO_NUMBER_MAX_VALUE).toSet().contains(lottoNumberOrNull)) {
            INVALID_WINNER_NUMBERS_LOTTO_RANGE_MESSAGE
        }

        return lottoNumberOrNull
    }

    const val INVALID_NULL_OR_BLANK_WINNER_NUMBERS_MESSAGE: String = "입력된 로또 당첨 번호가 없습니다"
    const val INVALID_NULL_OR_BLANK_BONUS_NUMBERS_MESSAGE: String = "입력된 보너스 번호가 없습니다"
    const val INVALID_BONUS_NUMBERS_MESSAGE: String = "입력된 보너스 번호가 올바르지 않습니다"
    const val INVALID_BLANK_WINNER_NUMBERS_MESSAGE: String = "입력된 로또 당첨 번호가 공백입니다"
    const val INVALID_DELIMITER_WINNER_NUMBERS_MESSAGE: String = "로또 당첨 번호 구분자가 올바르지 않습니다"
    const val WINNER_NUMBERS_DELIMITER: String = ","
    const val INVALID_WINNER_NUMBERS_TO_INT_MESSAGE: String = "로또 당첨 번호가 숫자로 입력되지 않았습니다"
    const val INVALID_WINNER_NUMBERS_LOTTO_RANGE_MESSAGE: String = "로또 당첨 번호가 1~45 사이의 숫자가 아닙니다"
    const val LOTTO_NUMBER_MIN_VALUE: Int = 1
    const val LOTTO_NUMBER_MAX_VALUE: Int = 45
    const val INVALID_WINNER_NUMBERS_COUNT_MESSAGE: String = "로또 당첨 번호가 중복되지 않은 6개로 입력되지 않았습니다"
}
