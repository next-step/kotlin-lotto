package com.nextstep.jngcii.lotto.service

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource
import org.junit.jupiter.params.provider.ValueSource

class InputValidatorTest {
    @ParameterizedTest
    @ValueSource(strings = ["", "  ", "1", "1234", " -123", "abc", "!@#$%^"])
    fun `notNull 체크`(input: String) {
        assertThat(
            InputValidator.validateNotNull(input)
        ).isEqualTo(input)
    }

    @Test
    fun `null 체크`() {
        assertThrows<IllegalArgumentException>("입력값이 null일 수 없습니다.") {
            InputValidator.validateNotNull(null)
        }
    }

    @ParameterizedTest
    @CsvSource(
        "1, 1",
        "-1, -1",
        "0, 0",
        "1111, 1111",
        "1234567, 1234567"
    )
    fun `적절한 정수 체크`(input: String, result: Int) {
        assertThat(InputValidator.validateInt(input)).isEqualTo(result)
    }

    @ParameterizedTest
    @ValueSource(strings = ["", "  ", "abc", "!@#$%^"])
    fun `부적절 정수 체크`(input: String) {
        assertThrows<IllegalArgumentException>("정수만 입력 가능합니다.") {
            InputValidator.validateInt(input)
        }
    }

    @ParameterizedTest
    @ValueSource(ints = [1, 2, 1111, 123456])
    fun `양의 정수 체크`(input: Int) {
        assertThat(
            InputValidator.validatePositive(input)
        ).isEqualTo(input)
    }

    @ParameterizedTest
    @ValueSource(ints = [0, -1, -2, -1111, -123456])
    fun `음의 정수 체크`(input: Int) {
        assertThrows<IllegalArgumentException>("양의 정수만 입력 가능합니다.") {
            InputValidator.validatePositive(input)
        }
    }
}
