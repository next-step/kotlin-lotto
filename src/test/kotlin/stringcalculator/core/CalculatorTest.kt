package stringcalculator.core

import io.kotest.matchers.shouldBe
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

class CalculatorTest {
    @ParameterizedTest
    @CsvSource(
        "0, 1, 1",
        "0, 2, 3",
        "0, 3, 6",
        "0, 4, 10",
    )
    fun `숫자의 합을 구하는 기능을 테스트한다`(
        start: Int,
        end: Int,
        result: Int,
    ) {
        val list = (start..end).toList()
        val numbers = list.map { num -> Number(num.toString()) }
        Calculator.sum(numbers) shouldBe result
    }
}
