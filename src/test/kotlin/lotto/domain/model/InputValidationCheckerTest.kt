package lotto.domain.model

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertAll

class InputValidationCheckerTest {
    @Test
    fun `InputValidationChecker는 재시도 메세지와 검증식을 보관한다`() {
        val retryMessage = "다시 시도해 주세요"
        val validate = { _: String -> true }
        val inputValidationChecker = InputValidationChecker(retryMessage, validate)

        assertAll(
            { assertThat(inputValidationChecker.retryMessage).isEqualTo(retryMessage) },
            { assertThat(inputValidationChecker.validate).isEqualTo(validate) }
        )
    }
}
