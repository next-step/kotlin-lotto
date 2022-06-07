package addingCalculator.entity

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test

internal class CalculatorImplTest {

    @Test
    fun `1 colon 2 colon 3을 계산하면 6이 나온다`() {
        // given
        val testNotation = "1:2:3"
        val testParser = ColonParserImpl()
        val calculator = CalculatorImpl(testParser)

        // when
        val result = calculator.evaluate(testNotation)

        // then
        Assertions.assertThat(result).isEqualTo(6)
    }

    @Test
    fun `1,2,3을 계산하면 6이 나온다`() {
        // given
        val testNotation = "1,2,3"
        val testParser = CommaParserImpl()
        val calculator = CalculatorImpl(testParser)

        // when
        val result = calculator.evaluate(testNotation)

        // then
        Assertions.assertThat(result).isEqualTo(6)
    }

    @Test
    fun `1 , 2 colon 3을 계산하면 6이 나온다`() {
        // given
        val testNotation = "1,2:3"
        val testParser = ComplexParserImpl()
        val calculator = CalculatorImpl(testParser)

        // when
        val result = calculator.evaluate(testNotation)

        // then
        Assertions.assertThat(result).isEqualTo(6)
    }

    @Test
    fun `testNotation을 계산하면 6이 나온다`() {
        // given
        val testNotation = "//;\n1;2;3"
        val testParser = CustomParserImpl()
        val calculator = CalculatorImpl(testParser)

        // when
        val result = calculator.evaluate(testNotation)

        // then
        Assertions.assertThat(result).isEqualTo(6)
    }

    @Test
    fun `숫자 하나를 문자열로 입력할 경우 해당 숫자를 반환한다`() {
        // given
        val testNotation = "3"
        val testParser = CommaParserImpl()
        val calculator = CalculatorImpl(testParser)

        // when
        val result = calculator.evaluate(testNotation)

        // then
        Assertions.assertThat(result).isEqualTo(3)
    }

    @Test
    fun `빈 문자열을 입력할 경우 0을 반환해야 한다`() {
        // given
        val testNotation = ""
        val testParser = ColonParserImpl()
        val calculator = CalculatorImpl(testParser)

        // when
        val result = calculator.evaluate(testNotation)

        // then
        Assertions.assertThat(result).isEqualTo(0)
    }

    @Test
    fun `null을 입력할 경우 0을 반환해야 한다`() {
        // given
        val testNotation = null
        val testParser = ColonParserImpl()
        val calculator = CalculatorImpl(testParser)

        // when
        val result = calculator.evaluate(testNotation)

        // then
        Assertions.assertThat(result).isEqualTo(0)
    }
}
