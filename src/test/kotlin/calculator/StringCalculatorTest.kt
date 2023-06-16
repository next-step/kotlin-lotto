package calculator

import io.kotest.matchers.collections.shouldContainExactly
import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class StringCalculatorTest {

    private lateinit var parser: ExpressionParser
    private lateinit var calculator: StringCalculator
    @BeforeEach
    fun setup() {
        parser = ExpressionParser()
        val testData = parser.parseInputData("//;\\n1;2;3")
        calculator = StringCalculator(testData)
    }

    @Test
    fun `문자열을 , 구분자로 구분한다`() {
        val splitData = parser.parseInputData("1,2,3")
        splitData.size shouldBe 3
        splitData shouldContainExactly(listOf("1", "2", "3"))
    }

    @Test
    fun `문자열을 콜론 구분자로 구분한다`() {
        val splitData = parser.parseInputData("1:2:3")
        splitData.size shouldBe 3
        splitData shouldContainExactly(listOf("1", "2", "3"))
    }

    @Test
    fun `문자열을 , 또는 콜론 구분자로 구분한다`() {
        val splitData = parser.parseInputData("1,2:3")
        splitData.size shouldBe 3
        splitData shouldContainExactly(listOf("1", "2", "3"))
    }

    @Test
    fun `커스텀 구분자를 구한다`() {
        val matchResult = parser.parseInputData("//;\\n1;2;3")
        matchResult.size shouldBe 3
        matchResult.shouldContainExactly(listOf("1", "2", "3"))
    }

    @Test
    fun `구분한 문자열 값을 더한다`() {
        val sumData = calculator.execute()
        sumData shouldBe 6
    }
}
