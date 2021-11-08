package lotto.domain

import org.assertj.core.api.Assertions.assertThatIllegalArgumentException
import org.junit.jupiter.api.Test

class LottoNumberTest {

    @Test
    fun `문자열을 입력받은 경우 예외를 발생시킨다`() {
        assertThatIllegalArgumentException().isThrownBy { LottoNumber("H") }
            .withMessage(ExceptionType.INPUT_MUST_UNSIGNED_INT)
    }
}
