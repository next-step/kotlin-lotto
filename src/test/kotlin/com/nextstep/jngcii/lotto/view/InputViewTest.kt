package com.nextstep.jngcii.lotto.view

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.CsvSource
import org.junit.jupiter.params.provider.MethodSource
import org.junit.jupiter.params.provider.ValueSource

internal class InputViewTest {
    @ParameterizedTest
    @ValueSource(strings = ["apple", "!@#$", " ", "", "1.5"])
    fun `digit이 아닌 문자열을 입력하면 예외 발생`(input: String) {
        assertThrows<IllegalArgumentException>("정수만 입력 가능합니다.") {
            InputView.getCount { input }
        }
    }

    @Test
    fun `음의 정수에 해당하는 문자열을 입력하면 예외 발생`() {
        val input = "-10"

        assertThrows<IllegalArgumentException>("양의 정수만 입력 가능합니다.") {
            InputView.getCount { input }
        }
    }

    @Test
    fun `null을 입력받은 경우 0을 반환`() {
        val actual: Int = InputView.getCount { null }
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
        val actual: Int = InputView.getCount { input }
        Assertions.assertThat(actual).isEqualTo(expected)
    }

    @ParameterizedTest
    @MethodSource("nullOrBlank")
    fun `(당첨번호 파싱) null을 입력받으면 예외 발생`(input: String?) {
        assertThrows<IllegalArgumentException>("입력값이 없습니다") {
            InputView.getNumbers { input }
        }
    }

    @ParameterizedTest
    @ValueSource(
        strings = [
            "1, d, 3",
            "1, 2, 3, ",
            ";, !, @, n, ",
        ]
    )
    fun `(당첨번호 파싱) 콤마(,)로 구분된 각 원소가 digit이 아니면 예외를 발생`(input: String) {
        assertThrows<IllegalArgumentException>("정수만 입력 가능합니다.") {
            InputView.getNumbers { input }
        }
    }

    @Test
    fun `(당첨번호 파싱) 콤마로 구분한 숫자 리스트 반환`() {
        val numbers: List<Int> = InputView.getNumbers { "1, 2, 3, 4, 5, 6, 7, 8" }
        val expected = (1..8).toList()
        Assertions.assertThat(numbers).isEqualTo(expected)
    }

    companion object {
        @JvmStatic
        fun nullOrBlank() = listOf(
            Arguments.of(null),
            Arguments.of(""),
            Arguments.of("  "),
        )
    }
}
