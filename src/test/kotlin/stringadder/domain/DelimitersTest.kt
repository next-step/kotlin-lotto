package stringadder.domain

import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

internal class DelimitersTest {

    @DisplayName("커스텀 구분자를 입력한 경우 객체 생성")
    @Test
    fun constructor() {
        assertThat(Delimiters("//;\\n")).isNotNull
    }

    @DisplayName("커스텀 구분자를 잘못 입력한 경우 객체 생성")
    @ParameterizedTest
    @ValueSource(strings = ["/;\\n", "//;\n"])
    fun validateContainDelimiters(input: String) {
        assertThatThrownBy { Delimiters(input) }
            .isInstanceOf(IllegalArgumentException::class.java)
    }

    @DisplayName("커스텀 구분자를 입력하지 않은 경우 예외 발생")
    @Test
    fun validateContainDelimiters_exception() {
        assertThatThrownBy { Delimiters("1,2,3") }
            .isInstanceOf(IllegalArgumentException::class.java)
    }
}