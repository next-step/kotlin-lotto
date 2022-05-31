package com.nextstep.jngcii.calculator

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource

class InputViewTest {
    @ParameterizedTest
    @MethodSource("emptyOrBlankOrNull")
    fun `null, empty, blank를 넘긴 경우, listOf(0) 반환`(input: String?) {
        val numbers = InputView.getNumbers(input)

        assertThat(numbers).isEqualTo(listOf(0))
    }

    @ParameterizedTest
    @MethodSource("normalExpressions")
    fun `정상적인 상황에서는 파싱한 숫자 리스트 반환`(expression: String) {
        val numbers = InputView.getNumbers(expression)

        assertThat(numbers).isEqualTo(listOf(1, 2, 3))
    }

    companion object {
        @JvmStatic
        fun emptyOrBlankOrNull() = listOf(
            Arguments.of(null),
            Arguments.of(""),
            Arguments.of("   "),
        )

        @JvmStatic
        fun normalExpressions() = listOf(
            Arguments.of("1,2,3"),
            Arguments.of("//!\\n1!2!3"),
            Arguments.of("1:2,3"),
        )
    }
}
