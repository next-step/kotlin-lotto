package calculator.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.NullAndEmptySource
import org.junit.jupiter.params.provider.ValueSource

/**
 * Created by Jaesungchi on 2022.05.21..
 */
class CalculatorTest {
    @ParameterizedTest
    @ValueSource(strings = ["1,2,3,4", "1:2:3:4"])
    fun `쉼표 또는 콜론으로 문장을 잘 구분한다`(source: String) {
        assertThat(Calculator.getResultOfCalculate(source)).isEqualTo(10)
    }

    @ParameterizedTest
    @ValueSource(strings = ["//+\n1+2+3+4", "//;\n1;2;3;4"])
    fun `커스텀 구분자로 문장을 잘 분리한다`(source: String) {
        assertThat(Calculator.getResultOfCalculate(source)).isEqualTo(10)
    }

    @ParameterizedTest
    @ValueSource(strings = ["1,2,3,4", "1:2:3:4", "//+\n1+2+3+4"])
    fun `분리된 문장에서 계산을 하고 결과 값을 잘 받는다`(source: String) {
        assertThat(Calculator.getResultOfCalculate(source)).isEqualTo(10)
    }

    @ParameterizedTest
    @NullAndEmptySource
    fun `빈 문장 또는 null이 입력되면 0을 반환 한다`(source: String?) {
        assertThat(Calculator.getResultOfCalculate(source)).isEqualTo(0)
    }

    @ParameterizedTest
    @ValueSource(strings = ["3"])
    fun `숫자 하나만 입력되면 그대로 반환 한다`(source: String) {
        assertThat(Calculator.getResultOfCalculate(source)).isEqualTo(3)
    }
}
