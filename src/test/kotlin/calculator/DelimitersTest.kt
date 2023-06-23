package calculator

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class DelimitersTest {
    @DisplayName(value = "기본 구분자로 쉼표(,)와 콜론(:)을 가진다")
    @Test
    fun defaultDelimiter() {
        val delimiters = Delimiters()
        Assertions.assertThat(delimiters.getDelimiters()).isEqualTo(listOf(",", ":"))
    }

    @DisplayName(value = "커스텀 구분자로 별표(*)를 가진다")
    @ParameterizedTest
    @ValueSource(strings = ["*"])
    fun twoNumbers(delimiter: String) {
        val customDelimiters = Delimiters(delimiter)
        Assertions.assertThat(customDelimiters.getDelimiters()).isEqualTo(listOf(",", ":", "*"))
    }
}
