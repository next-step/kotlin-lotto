/*
 * Copyright (c) 2021. LINE Corporation. All rights reserved.
 * LINE Corporation PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package calculator

import org.assertj.core.api.Assertions
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource


class StringCalculatorTest {

    @ParameterizedTest
    @CsvSource(value = ["1,2=3", "2,3=5"], delimiter = '=')
    fun `컴마로 구분된 문자열을 입력받는다`(input: String, output: Int) {
        val result = StringCalculator.calculate(input)
        Assertions.assertThat(result).isEqualTo(output)
    }
}