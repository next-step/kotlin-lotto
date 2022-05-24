package stringcalculator.view

import stringcalculator.dto.InputDto
import stringcalculator.dto.OutPutDto

object CustomExpressionCalculatorView {
    fun getInputViewString(): String {
        return "커스텀 연산식을 입력해주세요. 형식은 //'구분자'\\n'숫자''구분자''숫자'.. 입니다"
    }

    fun getOutputViewString(inputDto: InputDto, outputDto: OutPutDto): String {
        return "${inputDto.inputString} 연산식의 총합은 ${outputDto.outPutInt} 입니다."
    }
}
