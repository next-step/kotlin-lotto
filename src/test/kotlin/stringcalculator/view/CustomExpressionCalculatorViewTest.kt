package stringcalculator.view

import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.shouldBe
import stringcalculator.dto.InputDto
import stringcalculator.dto.OutPutDto

class CustomExpressionCalculatorViewTest : DescribeSpec({
    it("getInputViewString 은 입력을 위한 ViewString 을 만들어준다") {
        // given
        val successInputViewString = "커스텀 연산식을 입력해주세요. 형식은 //'구분자'\\n'숫자''구분자''숫자'.. 입니다"
        val customExpressionCalculatorView = CustomExpressionCalculatorView()

        // then
        customExpressionCalculatorView.getInputViewString() shouldBe successInputViewString
    }

    it("getOutputViewString 은 입력을 위한 ViewString 을 만들어준다") {
        // given
        val successInputViewString = "1;2;3 연산식의 총합은 6 입니다."
        val customExpressionCalculatorView = CustomExpressionCalculatorView()
        val inputDto = InputDto("1;2;3")
        val outputDto = OutPutDto(6)

        // then
        customExpressionCalculatorView.getOutputViewString(inputDto, outputDto) shouldBe successInputViewString
    }
})
