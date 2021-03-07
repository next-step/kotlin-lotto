/*
 * Copyright (c) 2021. LINE Corporation. All rights reserved.
 * LINE Corporation PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package calculator

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource
import org.junit.jupiter.params.provider.ValueSource


class StringCalculatorTest {

    @ParameterizedTest
    @CsvSource(value = ["1,2=3", "2,3=5", "2,3,1=6"], delimiter = '=')
    fun `컴마로 구분된 문자열을 입력받는다`(input: String, output: Int) {
        val result = StringCalculator.calculate(input)
        assertThat(result).isEqualTo(output)
    }

    @ParameterizedTest
    @CsvSource(value = ["1:2=3", "2:3=5"], delimiter = '=')
    fun `콜론으로 구분된 문자열을 입력받는다`(input: String, output: Int) {
        val result = StringCalculator.calculate(input)
        assertThat(result).isEqualTo(output)
    }

    @ParameterizedTest
    @CsvSource(value = ["1,2:3=6", "10:2,3:1=16"], delimiter = '=')
    fun `콜론과 컴마로 구분된 문자열을 입력받는다`(input: String, output: Int) {
        val result = StringCalculator.calculate(input)
        assertThat(result).isEqualTo(output)
    }

    @ParameterizedTest
    @ValueSource(strings = ["//a\n1a2a3"])
    fun `커스텀 구분자로 구분된 문자열을 입력받는다_a`(input: String) {
        val result = StringCalculator.calculate(input)
        assertThat(result).isEqualTo(6)
    }

    @ParameterizedTest
    @ValueSource(strings = ["//a\n1a2,3:4"])
    fun `커스텀 구분자와 기본 구분자로 구분된 문자열을 입력받는다`(input: String) {
        val result = StringCalculator.calculate(input)
        assertThat(result).isEqualTo(10)
    }
}
