package calculator

import io.kotest.matchers.shouldBe
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource

class AdditionCalculatorTest {
    @ParameterizedTest
    @MethodSource("providedAdditionExpression")
    fun `입력한 문자열의 덧셈 결과를 얻을 수 있다`(
        inputText: String,
        additionResult: Int,
    ) {
        val unparsedExpression = UnparsedExpression(inputText)
        val result = AdditionCalculator.calculate(unparsedExpression)
        result shouldBe additionResult
    }

    companion object {
        @JvmStatic
        fun providedAdditionExpression() =
            listOf(
                Arguments.arguments("1,2,3,4,5,6,7,8,9,10", 55),
                Arguments.arguments("1:2:3:4:5:6:7:8:9:10", 55),
                Arguments.arguments("//^\n10^20^30", 60),
                Arguments.arguments("//#\n20#40#80#60", 200),
                Arguments.arguments("//*\n20*40,80:60", 200),
            )
    }
}
