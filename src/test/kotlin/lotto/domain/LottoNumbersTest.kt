package lotto.domain

import io.kotest.assertions.throwables.shouldThrowWithMessage
import lotto.domain.LottoNumbers.Companion.INVALID_LOTTO_NUMBER_COUNT_MESSAGE
import org.junit.jupiter.api.Test

class LottoNumbersTest {
    @Test
    fun `로또 번호가 6개로 이루어지지 않으면 에러가 발생한다`() {
        shouldThrowWithMessage<IllegalArgumentException>(message = INVALID_LOTTO_NUMBER_COUNT_MESSAGE) {
            LottoNumbers(1,2,3,4,5)
        }
        shouldThrowWithMessage<IllegalArgumentException>(message = INVALID_LOTTO_NUMBER_COUNT_MESSAGE) {
            LottoNumbers(1,2,3,4,5,6,7)
        }
    }
}
