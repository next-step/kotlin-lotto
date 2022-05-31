package com.nextstep.jngcii.lotto.view

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

internal class InputViewTest {
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
        assertThat(actual).isEqualTo(expected)
    }

    @Test
    fun `(당첨번호 파싱) 콤마로 구분한 숫자 리스트 반환`() {
        val numbers: List<Int> = InputView.getNumbers { "1, 2, 3, 4, 5, 6, 7, 8" }
        val expected = (1..8).toList()
        assertThat(numbers).isEqualTo(expected)
    }

    @ParameterizedTest
    @CsvSource(
        "1, 1",
        "2, 2",
        "10, 10",
        "100, 100",
    )
    fun `(보너스볼 파싱) 정수 반환`(input: String, expected: Int) {
        val number: Int = InputView.getNumber { input }
        assertThat(number).isEqualTo(expected)
    }
}
