package stringCalculator

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.AnnotationSpec
import io.kotest.matchers.shouldBe

class StringCalculatorTest : AnnotationSpec() {

    @Test
    fun `쉽표 또는 콜론을 구분자로 인식한다`() {
        val strings = listOf("1,2,3", "1,2:3", "1:2:3")
        strings.forEach {
            StringPlusCalculator.seperate(it) shouldBe listOf(1, 2, 3)
        }
    }

    @Test
    fun `앞의 기본 구분자(쉼표, 콜론) 외에 커스텀 구분자를 지정할 수 있다`() {
        val strings = listOf("//;\n1;2;3", "1,2:3", "1:2:3", "//;\n1,2;3", "//;\n1,2:3")
        strings.forEach {
            StringPlusCalculator.seperate(it) shouldBe listOf(1, 2, 3)
        }
    }

    @Test
    fun `구분자를 기준으로 값이 없는 경우 0으로 인식`() {
        val string = ""
        StringPlusCalculator.seperate(string) shouldBe listOf(0)
    }

    @Test
    fun `문자열 계산기에 숫자 이외의 값 또는 음수를 전달하는 경우 RuntimeException 예외를 throw`() {
        shouldThrow<RuntimeException> {
            val string = "-1,2:3"
            StringPlusCalculator.seperate(string)
        }

        shouldThrow<RuntimeException> {
            val string = "a,2:3"
            StringPlusCalculator.seperate(string)
        }
    }

    @Test
    fun `숫자 리스트가 오는 경우 합을 구한다`() {
        val data = listOf(1, 2, 3)
        StringPlusCalculator.calculate(data) shouldBe 6
    }

    @Test
    fun `공백의 경과 0의 경우 결과값도 0`() {
        val data = listOf(0)
        StringPlusCalculator.calculate(data) shouldBe 0
    }
}
