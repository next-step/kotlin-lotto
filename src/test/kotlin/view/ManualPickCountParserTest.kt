package view

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource
import org.junit.jupiter.params.provider.ValueSource

internal class ManualPickCountParserTest {
    @ParameterizedTest
    @ValueSource(
        strings = [
            "",
            "가"
        ]
    )
    fun `숫자가 아니라면 0을 반환`(input: String) {
        // when
        val actual = ManualPickCountParser.parse(input)
        // then
        assertThat(actual).isEqualTo(0)
    }

    @ParameterizedTest
    @CsvSource(
        "1,1",
        "10,10"
    )
    fun `양수값이나 0이면, 해당 값을 반환`(input: String, expected: Int) {
        // when
        val actual = ManualPickCountParser.parse(input)
        // then
        assertThat(actual).isEqualTo(expected)
    }

    @ParameterizedTest
    @CsvSource(
        "-1, 0",
        "-10, 0"
    )
    fun `음수면, 0을 반환`(input: String, expected: Int) {
        // when
        val actual = ManualPickCountParser.parse(input)
        // then
        assertThat(actual).isEqualTo(expected)
    }
}
