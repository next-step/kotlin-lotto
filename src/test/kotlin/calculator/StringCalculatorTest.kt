/*
 * Copyright (c) 2021. LINE Corporation. All rights reserved.
 * LINE Corporation PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package calculator

import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource
import org.junit.jupiter.params.provider.NullAndEmptySource
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

    @ParameterizedTest
    @ValueSource(strings = ["1:-1", "-1,1", "-1"])
    fun `음수를 입력받은 경우 예외를 throw`(input: String) {
        assertThatThrownBy { StringCalculator.calculate(input) }
            .isInstanceOf(RuntimeException::class.java)
    }

    @ParameterizedTest
    @ValueSource(strings = ["1;a", "a,1", "a"])
    fun `숫자가 아닌 값을 입력받은 경우 예외를 throw`(input: String) {
        assertThatThrownBy { StringCalculator.calculate(input) }
            .isInstanceOf(RuntimeException::class.java)
    }

    @ParameterizedTest
    @NullAndEmptySource
    fun `null 또는 빈 값을 입력받은 경우 0을 리턴`(input: String?) {
        val result = StringCalculator.calculate(input)
        assertThat(result).isEqualTo(0)
    }

    @ParameterizedTest
    @ValueSource(strings = ["1", "0"])
    fun `숫자 하나를 입력한 경우, 해당 숫자 리턴`(input: String) {
        val result = StringCalculator.calculate(input)
        assertThat(result).isEqualTo(input.toInt())
    }

    @ParameterizedTest
    @ValueSource(strings = ["//2\n1232324"])
    fun `구분자가 숫자로 나오는 경우`(input: String) {
        val result = StringCalculator.calculate(input)
        assertThat(result).isEqualTo(11)
    }

    @ParameterizedTest
    @ValueSource(strings = ["//2\n1222324"])
    fun `숫자로 나온 구분자가 숫자로 사용되는 경우`(input: String) {
        assertThatThrownBy { StringCalculator.calculate(input) }
            .isInstanceOf(RuntimeException::class.java)
    }
}
