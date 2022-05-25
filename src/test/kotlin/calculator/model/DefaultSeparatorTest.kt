package calculator.model

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

@DisplayName("기본 분리자 테스트")
class DefaultSeparatorTest {

    @ParameterizedTest(name = "{0} = {1}")
    @CsvSource(
        "1 = true",
        "1,2 = true",
        "1,2:3 = true",
        "1:2,3,4 = true",
        "1,2:3:4 = true",
        "1;2 = false",
        "1;2*3 = false",
        delimiter = '='
    )
    fun `구분자가 쉼표 또는 콜론으로 이뤄지면 분리 가능`(input: String, isSeparable: Boolean) {
        // when, then
        assertEquals(DefaultSeparator.isSeparable(input), isSeparable)
    }

    @ParameterizedTest(name = "{0} = {1}")
    @CsvSource(
        "1 = 1",
        "1,2 = 2",
        "1,2:3 = 3",
        "1:2,3,4 = 4",
        "1,2:3:4 = 4",
        delimiter = '='
    )
    fun `구분자가 쉼표 또는 콜론으로 이뤄지면 정상 분리`(input: String, size: Int) {
        // when, then
        assertEquals(DefaultSeparator.separate(input).size, size)
    }

    @Test
    fun `기본 인풋 패턴과 매치되지 않으면 분리시 예외 발생`() {
        // given, when, then
        val exception = assertThrows<IllegalArgumentException> { DefaultSeparator.separate("1&2") }
        assertEquals("기본 인풋 패턴과 매치되지 않습니다. (input: 1&2)", exception.message)
    }
}
