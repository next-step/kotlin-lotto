package com.nextstep.jngcii.lotto.view

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource
import org.junit.jupiter.params.provider.ValueSource

internal class InputViewTest {
    @ParameterizedTest
    @ValueSource(strings = ["apple", "!@#$", " ", "", "1.5"])
    fun `digit이 아닌 문자열을 입력하면 예외 발생`(input: String) {
        org.junit.jupiter.api.assertThrows<IllegalArgumentException>("정수만 입력 가능합니다.") {
            InputView.getCount(input)
        }
    }

    @Test
    fun `음의 정수에 해당하는 문자열을 입력하면 예외 발생`() {
        val input = "-10"

        org.junit.jupiter.api.assertThrows<IllegalArgumentException>("양의 정수만 입력 가능합니다.") {
            InputView.getCount(input)
        }
    }

    @Test
    fun `null을 입력받은 경우 0을 반환`() {
        val actual: Int = InputView.getCount(null)
        Assertions.assertThat(actual).isEqualTo(0)
    }

    @ParameterizedTest
    @CsvSource(
        "1000, 1",
        "2000, 2",
        "1234, 1",
        "1, 0",
        "30000, 30"
    )
    fun `양의 정수를 입력하면 1000으로 나눈 몫을 반환`(input: String, expected: Int) {
        val actual: Int = InputView.getCount(input)
        Assertions.assertThat(actual).isEqualTo(expected)
    }
}
