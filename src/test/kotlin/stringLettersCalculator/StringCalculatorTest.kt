package stringLettersCalculator

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource

class StringCalculatorTest {

    @ParameterizedTest
    @MethodSource("splitDefaultDelimiterProvider")
    fun `기본 구분자인 쉼표와 콜론을 입력을 받았을 때의 합을 구한다`(
        givenStringValue: String,
        expected: Int,
    ) {
        // Given
        val stringCalculator = StringCalculator()

        // When
        val actual = stringCalculator.calculate(givenStringValue)

        // Then
        assertThat(actual).isSameAs(expected)
    }

    @ParameterizedTest
    @MethodSource("splitCustomDelimiterProvider")
    fun `커스텀 구분자를 입력을 받았을 때의 합을 구한다`(
        givenStringValue: String,
        expected: Int,
    ) {
        // Given
        val stringCalculator = StringCalculator()

        // When
        val actual = stringCalculator.calculate(givenStringValue)

        // Then
        assertThat(actual).isSameAs(expected)
    }

    @ParameterizedTest
    @MethodSource("splitDefaultAndCustomDelimiterProvider")
    fun `기본구분자와 커스텀 구분자를 동시에 주입 받았을 때의 합을 구한다`(
        givenStringValue: String,
        expected: Int,
    ) {
        // Given
        val stringCalculator = StringCalculator()

        // When
        val actual = stringCalculator.calculate(givenStringValue)

        // Then
        assertThat(actual).isSameAs(expected)
    }

    @Test
    fun `구분자이외의 특수문자를 주입받으면 에러를 반환한다`() {
        // Given
        val givenStringValue = "1.2,3:4"
        val stringCalculator = StringCalculator()

        // When & Then
        assertThrows<RuntimeException> {
            stringCalculator.calculate(givenStringValue)
        }
    }

    @Test
    fun `음수를 주입받으면 에러를 반환한다`() {
        // Given
        val givenStringValue = "1,-2,3:4"
        val stringCalculator = StringCalculator()

        // When & Then
        assertThrows<RuntimeException> {
            stringCalculator.calculate(givenStringValue)
        }
    }

    companion object {
        @JvmStatic
        fun splitDefaultDelimiterProvider() = listOf(
            Arguments.of("1,2", 3),
            Arguments.of("11:22", 33),
            Arguments.of("1:3,2", 6),
        )

        @JvmStatic
        fun splitCustomDelimiterProvider() = listOf(
            Arguments.of("//?\n1?2", 3),
            Arguments.of("//*\n11*22", 33),
            Arguments.of("//-\n1-3-2", 6),
        )

        @JvmStatic
        fun splitDefaultAndCustomDelimiterProvider() = listOf(
            Arguments.of("//?\n1?2,3:4", 10),
            Arguments.of("//*\n11*22:1,2", 36),
            Arguments.of("//-\n1-3-2,4:5", 15),
        )
    }
}
