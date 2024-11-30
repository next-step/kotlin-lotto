package lotto.domain

import io.kotest.assertions.throwables.shouldThrowWithMessage
import lotto.domain.LottoWinnerNumbers.Companion.INVALID_BLANK_WINNER_NUMBERS_MESSAGE
import lotto.domain.LottoWinnerNumbers.Companion.INVALID_DELIMITER_WINNER_NUMBERS_MESSAGE
import lotto.domain.LottoWinnerNumbers.Companion.INVALID_NULL_OR_BLANK_WINNER_NUMBERS_MESSAGE
import lotto.domain.LottoWinnerNumbers.Companion.INVALID_WINNER_NUMBERS_COUNT_MESSAGE
import lotto.domain.LottoWinnerNumbers.Companion.INVALID_WINNER_NUMBERS_LOTTO_RANGE_MESSAGE
import lotto.domain.LottoWinnerNumbers.Companion.INVALID_WINNER_NUMBERS_TO_INT_MESSAGE
import org.junit.jupiter.api.Test

class LottoWinnerNumbersTest {

    @Test
    fun `로또 당첨 번호가 입력되지 않으면 에러가 발생한다`() {
        shouldThrowWithMessage<IllegalArgumentException>(message = INVALID_NULL_OR_BLANK_WINNER_NUMBERS_MESSAGE) {
            LottoWinnerNumbers(inputWinnerNumbersCommand = null)
        }
    }

    @Test
    fun `로또 당첨 번호가 공백으로 입력되면 에러가 발생한다`() {
        shouldThrowWithMessage<IllegalArgumentException>(message = INVALID_BLANK_WINNER_NUMBERS_MESSAGE) {
            LottoWinnerNumbers(inputWinnerNumbersCommand = "      ")
        }
    }

    @Test
    fun `로또 당첨 번호의 구분자가 올바르지 않으면 에러가 발생한다`() {
        shouldThrowWithMessage<IllegalArgumentException>(message = INVALID_DELIMITER_WINNER_NUMBERS_MESSAGE) {
            LottoWinnerNumbers(inputWinnerNumbersCommand = "1;2;3;4;5;6")
        }
    }

    @Test
    fun `로또 당첨 번호가 구분자 제외 숫자로 이루어져 있지 않으면 에러가 발생한다`() {
        shouldThrowWithMessage<IllegalArgumentException>(message = INVALID_WINNER_NUMBERS_TO_INT_MESSAGE) {
            LottoWinnerNumbers(inputWinnerNumbersCommand = "1,2,3,4,5,6t")
        }
    }

    @Test
    fun `로또 당첨 번호가 1부터 45사이의 숫자가 아닐 경우 에러가 발생한다`() {
        shouldThrowWithMessage<IllegalArgumentException>(message = INVALID_WINNER_NUMBERS_LOTTO_RANGE_MESSAGE) {
            LottoWinnerNumbers(inputWinnerNumbersCommand = "1,2,3,4,5,46")
        }
    }

    @Test
    fun `로또 당첨 번호가 6개가 아닐 경우 에러가 발생한다`() {
        shouldThrowWithMessage<IllegalArgumentException>(message = INVALID_WINNER_NUMBERS_COUNT_MESSAGE) {
            LottoWinnerNumbers(inputWinnerNumbersCommand = "1,2,3,4,5,6,7")
        }
    }
}
