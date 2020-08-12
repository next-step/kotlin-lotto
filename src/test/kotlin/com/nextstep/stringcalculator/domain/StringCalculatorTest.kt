package com.nextstep.stringcalculator.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

internal class StringCalculatorTest {
    @ParameterizedTest
    @ValueSource(strings = ["1;2;3"])
    fun `커스텀 구분자가 없다면 기본 구분자 스플릿 된 계산기를 생성한다`(userInput: String) {
        val calculator = StringCalculator.createCalculator(userInput)

        assertThat(calculator.numbers.size).isEqualTo(3)
        assertThat(calculator.numbers).contains(1)
        assertThat(calculator.numbers).contains(2)
        assertThat(calculator.numbers).contains(3)
    }

    @ParameterizedTest
    @ValueSource(strings = ["//a\\n1a2a3"])
    fun `커스텀 구분자가 있다면 해당 구분자로 스플릿 된 계산기를 생성한다`(userInput: String) {
        val calculator = StringCalculator.createCalculator(userInput)

        assertThat(calculator.numbers.size).isEqualTo(3)
        assertThat(calculator.numbers).contains(1)
        assertThat(calculator.numbers).contains(2)
        assertThat(calculator.numbers).contains(3)
    }

    @ParameterizedTest
    @ValueSource(strings = ["-1;2;3"])
    fun `숫자 중에 자연수가 아닌 수가 있다면 에러를 발생한다`(userInput: String) {
        assertThrows<IllegalArgumentException> {
            StringCalculator.createCalculator(userInput)
        }
    }

    @ParameterizedTest
    @ValueSource(strings = [""])
    fun `입력값이 비어있으면 0을 리턴한다`(userInput: String) {
        val calculator = StringCalculator.createCalculator(userInput)

        assertThat(calculator.numbers).hasSize(1)
        assertThat(calculator.numbers).contains(0)
    }

    @ParameterizedTest
    @ValueSource(strings = ["//a\\n1a2a3"])
    fun `split된 숫자들을 더하여 리턴해준다`(userInput: String) {
        val calculator = StringCalculator.createCalculator(userInput)

        assertThat(calculator.calculate()).isEqualTo(6)
    }
}
