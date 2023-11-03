package stringAdditionCalculator

import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.NullAndEmptySource
import org.junit.jupiter.params.provider.ValueSource

class AdditionCalculatorTest {

    private val defaultAdditionCalculator: AdditionCalculator = AdditionCalculator(StringParser(SeparatorParser.DEFAULT_SEPARATOR_LIST))

    @ParameterizedTest
    @NullAndEmptySource
    fun `빈 문자열 또는 null 을 입력할 경우, 0을 반환한다`(input: String?) {
        val result: Int = defaultAdditionCalculator.calculate(input)

        assert(result == 0)
    }

    @ParameterizedTest
    @ValueSource(strings = ["1,2,3,4,5", "1:2:3:4:5", "1,2:3:4:5", "1:2,3:4:5"])
    fun `매개 변수의 숫자를 모두 더해 반환한다`(input: String) {
        val result: Int = defaultAdditionCalculator.calculate(input)

        assert(result == 15)
    }
}
