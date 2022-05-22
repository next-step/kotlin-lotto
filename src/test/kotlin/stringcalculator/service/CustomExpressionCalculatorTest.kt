package stringcalculator.service

import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.shouldBe
import stringcalculator.dto.InputDto
import stringcalculator.dto.OutPutDto

class CustomExpressionCalculatorTest : DescribeSpec({
    it("'1,2:3' 을 넣으면 총합 6 이 나온다") {
        // given
        val expression = "1,2:3"
        val customExpressionCalculator = CustomExpressionCalculator(InputDto(expression))

        // when
        val total = customExpressionCalculator.getTotal()

        // then
        val successOutPutDto = OutPutDto(6)
        total shouldBe successOutPutDto
    }

    it("커스텀 구분자가 포함된 //;\n1;2;3 을 넣으면 총합 6이 나온다") {
        // given
        val expression = "//;\n1;2;3"
        val customExpressionCalculator = CustomExpressionCalculator(InputDto(expression))

        // when
        val total = customExpressionCalculator.getTotal()

        // then
        val successOutPutDto = OutPutDto(6)
        total shouldBe successOutPutDto
    }
})
