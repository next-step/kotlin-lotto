package lotto.domain

import lotto.domain.LottoTicket.Companion.LOTTO_NUMBER_COUNT
import lotto.domain.LottoTicket.Companion.LOTTO_NUMBER_MAX_VALUE
import lotto.domain.LottoTicket.Companion.LOTTO_NUMBER_MIN_VALUE

class LottoWinnerNumbers(private val inputWinnerNumbersCommand: String?) {
    val winnerNumbers: Set<Int>

    init {
        val splitWinnerNumbers = splitInputWinnerNumbersCommand()
        require(splitWinnerNumbers.size == LOTTO_NUMBER_COUNT) { INVALID_WINNER_NUMBERS_COUNT_MESSAGE }
        winnerNumbers = splitWinnerNumbers.toSet()
        require(winnerNumbers.size == LOTTO_NUMBER_COUNT) { INVALID_WINNER_NUMBERS_COUNT_MESSAGE }
    }

    private fun splitInputWinnerNumbersCommand(): List<Int> {
        requireNotNull(inputWinnerNumbersCommand) { INVALID_NULL_OR_BLANK_WINNER_NUMBERS_MESSAGE }
        require(inputWinnerNumbersCommand.isNotBlank()) { INVALID_BLANK_WINNER_NUMBERS_MESSAGE }
        require(inputWinnerNumbersCommand.contains(WINNER_NUMBERS_DELIMITER)) {
            INVALID_DELIMITER_WINNER_NUMBERS_MESSAGE
        }

        return inputWinnerNumbersCommand.split(WINNER_NUMBERS_DELIMITER)
            .map { inputWinnerNumber -> lottoNumberStringToInt(inputWinnerNumber) }
    }

    private fun lottoNumberStringToInt(numberString: String): Int {
        val lottoNumberOrNull = numberString.toIntOrNull()

        requireNotNull(lottoNumberOrNull) { INVALID_WINNER_NUMBERS_TO_INT_MESSAGE }
        require((LOTTO_NUMBER_MIN_VALUE..LOTTO_NUMBER_MAX_VALUE).toSet().contains(lottoNumberOrNull)) {
            INVALID_WINNER_NUMBERS_LOTTO_RANGE_MESSAGE
        }

        return lottoNumberOrNull
    }

    companion object {
        const val INVALID_NULL_OR_BLANK_WINNER_NUMBERS_MESSAGE: String = "입력된 로또 당첨 번호가 없습니다"
        const val INVALID_BLANK_WINNER_NUMBERS_MESSAGE: String = "입력된 로또 당첨 번호가 공백입니다"
        const val INVALID_DELIMITER_WINNER_NUMBERS_MESSAGE: String = "로또 당첨 번호 구분자가 올바르지 않습니다"
        const val WINNER_NUMBERS_DELIMITER: String = ","
        const val INVALID_WINNER_NUMBERS_TO_INT_MESSAGE: String = "로또 당첨 번호가 숫자로 입력되지 않았습니다"
        const val INVALID_WINNER_NUMBERS_LOTTO_RANGE_MESSAGE: String = "로또 당첨 번호가 1~45 사이의 숫자가 아닙니다"
        const val INVALID_WINNER_NUMBERS_COUNT_MESSAGE: String = "로또 당첨 번호가 중복되지 않은 6개로 입력되지 않았습니다"
    }
}
