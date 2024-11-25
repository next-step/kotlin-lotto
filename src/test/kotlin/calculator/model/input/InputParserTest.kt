package calculator.model.input

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.matchers.shouldBe
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.NullAndEmptySource
import org.junit.jupiter.params.provider.ValueSource

class InputParserTest {
    @ParameterizedTest
    @ValueSource(strings = ["|0", "1,2|3", "1,2,3|6"])
    fun `커스텀 구분자 및 연산에 사용될 숫자 목록 추출`(input: String) {
        val (expression, result) = input.split("|")
        val numbers = InputParser.parse(expression)
        result shouldBe numbers.sum().toString()
    }

    @ParameterizedTest
    @ValueSource(strings = ["-10|-10", "1,-2|-1", "1,-2,-3|-4"])
    fun `계산식에 음수는 계산 불가`(input: String) {
        val (expression, _) = input.split("|")
        shouldThrow<IllegalArgumentException> {
            InputParser.parse(expression)
        }.apply {
            message shouldBe "음수는 계산할 수 없습니다."
        }
    }

    @ParameterizedTest
    @NullAndEmptySource
    fun `빈 문자열 또는 null 값을 입력할 경우 0을 반환해야 한다`(input: String?) {
        val numbers = InputParser.parse(input)
        numbers.sum() shouldBe 0
    }

    @ParameterizedTest
    @ValueSource(strings = ["1", "5", "10"])
    fun `숫자 하나를 문자열로 입력할 경우 해당 숫자를 반환한다`(input: String) {
        val numbers = InputParser.parse(input)
        numbers.sum() shouldBe input.toInt()
    }

    @ParameterizedTest
    @ValueSource(strings = ["1,2:3:4,5", "5:4:3:2,1"])
    fun `구분자를 쉼표 이외에 콜론을 사용할 수 있다`(input: String) {
        val numbers = InputParser.parse(input)
        numbers.sum() shouldBe 15
    }
}
