package calculator

import io.kotest.matchers.collections.shouldContainExactly
import io.kotest.matchers.shouldBe
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class CalculatorTest {
    @ParameterizedTest
    @ValueSource(strings = ["1,2"])
    fun `문자열을 , 구분자로 구분한다`(input: String) {
        val splitData = input.split(",")
        splitData.size shouldBe 2
        splitData shouldContainExactly(listOf("1", "2"))
    }

    @ParameterizedTest
    @ValueSource(strings = ["3:5"])
    fun `문자열을 콜론 구분자로 구분한다`(input: String) {
        val splitData = input.split(":")
        splitData.size shouldBe 2
        splitData shouldContainExactly(listOf("3", "5"))
    }

    @ParameterizedTest
    @ValueSource(strings = ["1,3:5"])
    fun `문자열을 , 또는 콜론 구분자로 구분한다`(input: String) {
        val splitData = input.split(",|:".toRegex())
        splitData.size shouldBe 3
        splitData shouldContainExactly(listOf("1", "3", "5"))
    }

    @ParameterizedTest
    @ValueSource(strings = ["1,3:5"])
    fun `구분한 문자열 값을 더한다`(input: String) {
        val sumData = input.split(",|:".toRegex()).sumOf { it.toInt() }
        sumData shouldBe 9
    }
}
