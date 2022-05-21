package calculator.model

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

@DisplayName("숫자 테스트")
class NumberTest {

    @ParameterizedTest
    @ValueSource(strings = ["-1", "a1b2c3"])
    fun `음수 또는 숫자 이외의 값으로 생성하면 예외가 발생`(number: String) {
        // when, then
        val exception = assertThrows<IllegalArgumentException> { Number.from(number) }
        Assertions.assertEquals("0 이상의 숫자로만 생성이 가능합니다. (number: $number)", exception.message)
    }

    @ParameterizedTest
    @ValueSource(strings = ["0", "1"])
    fun `숫자가 0 이상이면 정상 생성`(number: String) {
        // when, then
        Number.from(number)
    }
}
