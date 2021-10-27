package domain.calculator.domain.result

import domain.calculator.domain.result.CalculateResult
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.assertAll
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

@DisplayName("계산 결과(CalculateResult)")
class CalculateResultTest {

    @ParameterizedTest
    @ValueSource(ints = [-1, -100, -1000, Integer.MIN_VALUE])
    fun `음수의 값을 가질 수 없다`(resultInt: Int) {
        assertThrows<RuntimeException> { CalculateResult(resultInt) }
    }

    @ParameterizedTest
    @ValueSource(ints = [0, 1, 100, Integer.MAX_VALUE])
    fun `값을 반환한다`(resultInt: Int) {
        val calculateResult = CalculateResult(resultInt)
        assertAll(
            { assertThat(calculateResult.result).isEqualTo(resultInt) },
            { assertThat(calculateResult.result).isGreaterThanOrEqualTo(0) },
        )
    }
}
