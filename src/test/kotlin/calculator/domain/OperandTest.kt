package calculator.domain

import calculator.constants.Messages
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test

/**
 * Created by Jaesungchi on 2022.05.21..
 */
class OperandTest {
    @Test
    fun `음수를 전달 받으면 RuntimeException을 throw한다`() {
        Assertions.assertThatExceptionOfType(RuntimeException::class.java).isThrownBy {
            Operand.of("-1")
        }.withMessageMatching(Messages.INSERT_NEGATIVE_NUMBER)
    }

    @Test
    fun `숫자 이외에 값을 전달 받으면 RuntimeException을 throw한다`() {
        Assertions.assertThatExceptionOfType(RuntimeException::class.java).isThrownBy {
            Operand.of("hi")
        }.withMessageMatching(Messages.INSERT_NOT_NUMBER)
    }
}
