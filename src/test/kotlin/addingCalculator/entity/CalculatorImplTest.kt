package addingCalculator.entity

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

internal class CalculatorImplTest {

  @Test
  fun `1 colon 2 colon 3을 계산하면 6이 나온다`() {
    // given
    val testNotation = "1:2:3"
    val testParser = ColonParserImpl()
    val calculator = CalculatorImpl(testParser)

    // when
    val result = calculator.evaluator(testNotation)

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
    val result = calculator.evaluator(testNotation)

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
    val result = calculator.evaluator(testNotation)

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
    val result = calculator.evaluator(testNotation)

    // then
    Assertions.assertThat(result).isEqualTo(6)
  }
}