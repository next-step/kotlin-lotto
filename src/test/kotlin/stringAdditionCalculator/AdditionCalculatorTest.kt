package stringAdditionCalculator

import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class AdditionCalculatorTest {

    @Test
    fun `빈 문자열을 입력할 경우, 0을 반환한다`() {
        val additionCalculator: AdditionCalculator = AdditionCalculator()

        val result: Int = additionCalculator.calculate("")

        assert(result == 0)
    }

    @ParameterizedTest
    @ValueSource(strings = ["1,2,3,4,5", "1:2:3:4:5", "1,2:3:4:5", "1:2,3:4:5"])
    fun `매개 변수의 숫자를 모두 더해 반환한다`(input: String) {
        val additionCalculator: AdditionCalculator = AdditionCalculator()

        val result: Int = additionCalculator.calculate(input)

        assert(result == 15)
    }
}
