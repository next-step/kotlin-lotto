package domain.calculator.domain

import org.junit.jupiter.api.DisplayName
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
}
