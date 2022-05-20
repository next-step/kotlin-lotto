package calculator.model

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

@DisplayName("숫자 테스트")
class NumberTest {

    @Test
    fun `숫자가 0 미만이면 예외가 발생`() {
        // given, when, then
        val exception = assertThrows<IllegalArgumentException> { Number.from(-1) }
        Assertions.assertEquals("숫자는 최소 0 이상이어야 합니다.", exception.message)
    }

    @Test
    fun `숫자가 0 이상이면 정상 발생`() {
        // given, when, then
        Number.from(0)
    }
}
