package com.nextstep.jngcii.lotto.view

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource

class InputValidatorTest {
    @ParameterizedTest
    @MethodSource("validCountString")
    fun `적절한 정수 체크`(input: String?, result: Int) {
        assertThat(InputValidator.validateInt(input)).isEqualTo(result)
    }

    @ParameterizedTest
    @MethodSource("invalidCountString")
    fun `부적절 정수 체크`(input: String?) {
        assertThat(InputValidator.validateInt(input)).isNull()
    }

    @ParameterizedTest
    @MethodSource("validNumbersString")
    fun `적절 당첨번호 체크`(input: String?, result: List<Int>) {
        assertThat(InputValidator.validateInputNumbers(input)).isEqualTo(result)
    }

    @ParameterizedTest
    @MethodSource("invalidNumbersString")
    fun `부적절 당첨번호 체크`(input: String?) {
        assertThat(InputValidator.validateInputNumbers(input)).isNull()
    }

    @ParameterizedTest
    @MethodSource("validNumberString")
    fun `적절 보너스번호 체크`(input: String?, result: Int) {
        assertThat(InputValidator.validateInputNumber(input)).isEqualTo(result)
    }

    @ParameterizedTest
    @MethodSource("invalidNumberString")
    fun `부적절 보너스번호 체크`(input: String?) {
        assertThat(InputValidator.validateInputNumber(input)).isNull()
    }

    companion object {
        @JvmStatic
        fun validCountString() = listOf(
            Arguments.of("0", 0),
            Arguments.of("1", 1),
            Arguments.of("1000", 1000),
            Arguments.of("1111", 1111),
        )

        @JvmStatic
        fun invalidCountString() = listOf(
            Arguments.of(null),
            Arguments.of(""),
            Arguments.of("  "),
            Arguments.of("abc"),
            Arguments.of("!@#$%^"),
        )

        @JvmStatic
        fun validNumbersString() = listOf(
            Arguments.of(
                "1",
                listOf(1)
            ),
            Arguments.of(
                "1, 1, 1",
                listOf(1, 1, 1)
            ),
            Arguments.of(
                "1, 2, 3, 4, 5, 6, 7",
                listOf(1, 2, 3, 4, 5, 6, 7)
            ),
        )

        @JvmStatic
        fun invalidNumbersString() = listOf(
            Arguments.of(null),
            Arguments.of(""),
            Arguments.of("  "),
            Arguments.of("1, d, 3"),
            Arguments.of("1, 2, 3, "),
            Arguments.of(";, !, @, n, "),
        )

        @JvmStatic
        fun validNumberString() = listOf(
            Arguments.of("1", 1),
            Arguments.of("10", 10),
            Arguments.of("100", 100),
        )

        @JvmStatic
        fun invalidNumberString() = listOf(
            Arguments.of(null),
            Arguments.of(""),
            Arguments.of("  "),
            Arguments.of("d"),
            Arguments.of("1, d, 3"),
        )
    }
}
