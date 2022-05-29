package advancedcalculate.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.EmptySource
import org.junit.jupiter.params.provider.ValueSource

internal class AdvancedCalculatorTest {
    @ParameterizedTest
    @ValueSource(strings = ["1,2,3", "//;\n1;2;3"])
    fun `어그리거트 루트로 계산기 수행을 담당한다`(input: String) {
        val advancedCalculator = AdvancedCalculator(input)

        val result = advancedCalculator.calculate()

        assertThat(result).isEqualTo(6.0)
    }

    @ParameterizedTest
    @EmptySource
    internal fun `빈 문자열 테스트`(input: String) {
        val advancedCalculator = AdvancedCalculator(input)

        val result = advancedCalculator.calculate()
        assertThat(result).isEqualTo(0.0)
    }
}
