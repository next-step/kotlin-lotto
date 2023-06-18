package calculator

import math.PositiveNumber
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.EmptySource
import org.junit.jupiter.params.provider.ValueSource

class StringParserTest {

    @DisplayName(value = "빈 문자열을 입력하면 비어있는 리스트를 반환한다")
    @ParameterizedTest
    @EmptySource
    fun empty(text: String) {
        assertTrue(StringParser.parse(text).isEmpty())
    }

    @DisplayName(value = "숫자 하나를 문자열로 입력할 경우 해당 숫자 한개를 담은 리스트를 반환한다")
    @Test
    fun oneNumber() {
        val expected = listOf(PositiveNumber(1))
        val actual = StringParser.parse("1")
        assertEquals(expected, actual)
    }

    @DisplayName(value = "숫자 두개를 쉼표(,) 구분자로 입력할 경우 숫자 두개를 담은 리스트를 반환한다")
    @Test
    fun twoNumbers() {
        val expected = arrayOf(1, 2).toPositiveNumbers()
        val actual = StringParser.parse("1,2")
        assertEquals(expected, actual)
    }

    @DisplayName(value = "숫자들을 쉼표(,)와 콜론(:)을 구분자로 입력할 경우, 구분자로 분리된 숫자 리스트를 반환한다")
    @Test
    fun colons() {
        listOf(
            arrayOf(1, 2, 3) to "1,2:3",
            arrayOf(10, 20, 30) to "10:20,30",
            arrayOf(1, 5, 4) to "1:5:4",
        ).forEach { (numbers, text) ->
            val expected = numbers.toPositiveNumbers()
            val actual = StringParser.parse(text)
            assertEquals(expected, actual)
        }
    }

    @DisplayName(value = "//와 \\n 문자 사이에 커스텀 구분자를 지정하여 숫자들을 입력할 경우, 구분자로 분리된 숫자 리스트를 반환한다")
    @Test
    fun customDelimiter() {
        listOf(
            arrayOf(1, 2, 3) to "//;\n1;2;3",
            arrayOf(10, 20, 30) to "//!\n10,20!30",
            arrayOf(20, 30, 50) to "//#\n20#30:50",
        ).forEach { (numbers, text) ->
            val expected = numbers.toPositiveNumbers()
            val actual = StringParser.parse(text)
            assertEquals(expected, actual)
        }
    }

    @DisplayName(value = "음수인 문자열을 전달하는 경우 RuntimeException 예외 처리를 한다.")
    @ParameterizedTest
    @ValueSource(strings = ["-1", "1:-1", "//;\n1;-1"])
    fun negative(text: String) {
        assertThrows<RuntimeException> { StringParser.parse(text) }
    }

    @DisplayName(value = "숫자가 아닌 값을 전달하는 경우 RuntimeException 예외 처리를 한다.")
    @ParameterizedTest
    @ValueSource(strings = ["a", "1:a", "//;\n1;a"])
    fun notInteger(text: String) {
        assertThrows<RuntimeException> { StringParser.parse(text) }
    }

    private fun Array<Int>.toPositiveNumbers(): List<PositiveNumber> {
        return map { PositiveNumber(it) }
    }
}
