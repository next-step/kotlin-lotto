package calculator.domain

import calculator.usecase.SplitParser
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class CalculatorImplTest {

    @ValueSource(strings = ["1,2,3", "1,2:3", "1:2:3"])
    @ParameterizedTest
    fun `1,2,3이 기본 separator 로 이루어졌을 때 결과 6`(input: String) {
        val parser = SplitParser()
        val calculator = CalculatorImpl(parser)

        val actual = calculator.calculate(input)

        assertEquals(6, actual)
    }

    @Test
    fun `10,20,30 일때 결과값 60`() {
        val input = "10,20,30"
        val parser = SplitParser()
        val calculator = CalculatorImpl(parser)

        val actual = calculator.calculate(input)

        assertEquals(60, actual)
    }

    @ValueSource(strings = ["//;\\n1;2;3", "//$\\n1$2$3", "//%\\n1%2%3"])
    @ParameterizedTest
    fun `1,2,3이 custom separator 로 이루어졌을 때 결과 6`(input: String) {
        val parser = SplitParser()
        val calculator = CalculatorImpl(parser)

        val actual = calculator.calculate(input)

        assertEquals(6, actual)
    }

    @Test
    @DisplayName("//;\n10;20;30 일때 결과값 60")
    fun `custom separator 로 이루어졌을 때 결과값 60`() {
        val input = """//;\n10;20;30"""
        val parser = SplitParser()
        val calculator = CalculatorImpl(parser)

        val actual = calculator.calculate(input)

        assertEquals(60, actual)
    }
}
