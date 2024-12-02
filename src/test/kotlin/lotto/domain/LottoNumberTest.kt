package lotto.domain

import io.kotest.assertions.throwables.shouldThrowWithMessage
import lotto.domain.LottoNumber.Companion.INVALID_WINNER_NUMBERS_RANGE_MESSAGE
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class LottoNumberTest {
    @ParameterizedTest
    @ValueSource(ints = [0, -1, 46, 47, 48, 49, 50])
    fun `로또 당첨 번호가 1부터 45사이의 숫자가 아닐 경우 에러가 발생한다`(number: Int) {
        shouldThrowWithMessage<IllegalArgumentException>(message = INVALID_WINNER_NUMBERS_RANGE_MESSAGE) {
            LottoNumber(number)
        }
    }
}
