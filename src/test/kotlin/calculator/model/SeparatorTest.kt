package calculator.model

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

@DisplayName("구분자 테스트")
class SeparatorTest {

    @Test
    fun `분리할 수 없는 인풋이면 예외 발생`() {
        // given
        val input = ":1,2:3"

        // when, then
        val exception = assertThrows<IllegalArgumentException> { Separator.separate(input) }
        assertEquals("분리할 수 없는 인풋입니다. (input: $input)", exception.message)
    }
}
