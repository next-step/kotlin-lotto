package calculator.utils

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

internal class SeparatorTest {

    @Test
    @DisplayName("구분자가 지정되지 않은 경우 쉼표(,) 또는 콜론(:)으로 구분함")
    fun `Separate by comma or colon if separator is not specified`() {
        val strings = Separator.divideBySeparator("", "1,2:3")
        assertThat(strings).isEqualTo(listOf("1", "2", "3"))
    }

    @Test
    @DisplayName("커스텀 구분자 세미콜론(;)으로 지정된 경우 세미콜론(;)으로 구분함")
    fun `Separate with a semicolon if specified as a custom delimiter semicolon`() {
        val strings = Separator.divideBySeparator(";", "1;2;3")
        assertThat(strings).isEqualTo(listOf("1", "2", "3"))
    }

    @Test
    @DisplayName("//;\n1;2;3 문자열이 입력된 경우 구분자는 세미콜론(;)")
    fun `If a string containing a semicolon is entered, the separator is a semicolon`() {
        val separator = Separator.findSeparatorInString("//;\n1;2;3")
        assertThat(separator).isEqualTo(";")
    }

    @Test
    @DisplayName("1;2;3 문자열이 입력된 경우 세미콜론(;)으로 구분하여 배열 {'1', '2', '3'}을 만듬")
    fun `Create an array {'1', '2', '3'} separated by semicolons if a string is entered`() {
        val strings = Separator.divideBySeparator(";", "1;2;3")
        assertThat(strings).isEqualTo(listOf("1", "2", "3"))
    }

    @Test
    @DisplayName("//;\n1;2;3 문자열이 입력된 경우 \n뒤에 따라오는 1;2;3문자만 꺼냄")
    fun `Just the text at the end`() {
        val strings = Separator.getStringToAdd("//;\n1;2;3")
        assertThat(strings).isEqualTo("1;2;3")
    }
}
