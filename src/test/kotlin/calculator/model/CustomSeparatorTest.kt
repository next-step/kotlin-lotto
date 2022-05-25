package calculator.model

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

@DisplayName("사용자 정의 분리자 테스트")
class CustomSeparatorTest {

    @Test
    fun `사용자 정의 인풋 패턴과 매치되면 분리 가능`() {
        // given
        val input = "//;\n1;2;3"

        // when, then
        assertEquals(CustomSeparator.isSeparable(input), true)
        assertEquals(CustomSeparator.separate(input).size, 3)
    }

    @Test
    fun `사용자 정의 인풋 패턴과 매치되지 않으면 분리 불가능`() {
        // given
        val input = "1:2,3"

        // when, then
        assertEquals(CustomSeparator.isSeparable(input), false)
    }

    @Test
    fun `사용자 정의 인풋 패턴과 매치되지 않으면 분리시 예외 발생`() {
        // given, when, then
        val exception = assertThrows<IllegalArgumentException> { CustomSeparator.separate("1,2:3") }
        assertEquals("사용자 정의 인풋 패턴과 매치되지 않습니다. (input: 1,2:3)", exception.message)
    }
}
